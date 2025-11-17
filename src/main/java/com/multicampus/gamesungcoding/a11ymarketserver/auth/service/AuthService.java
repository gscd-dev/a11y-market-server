package com.multicampus.gamesungcoding.a11ymarketserver.auth.service;

import com.multicampus.gamesungcoding.a11ymarketserver.auth.dto.*;
import com.multicampus.gamesungcoding.a11ymarketserver.user.model.Users;
import com.multicampus.gamesungcoding.a11ymarketserver.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRespDTO login(LoginDTO dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();

        var optionalUser = userRepository.findByUserEmail(email);

        if (optionalUser.isEmpty()) {
            return null;
        }

        Users user = optionalUser.get();


        if (passwordEncoder.matches(password, user.getUserPass())) {
            return UserRespDTO.fromEntity(user);
        }

        return null;
    }

    public UserRespDTO join(JoinRequestDTO dto) {
        // 이메일 중복 체크
        if (userRepository.existsByUserEmail(dto.getEmail())) {
            return null;
        }
        // 비밀번호 암호화
        String encodedPwd = passwordEncoder.encode(dto.getPassword());

        // UUID 생성
        // UUID userId = UUID.randomUUID();

        Users user = Users.builder()
                .userEmail(dto.getEmail())
                .userPass(encodedPwd)
                .userName(dto.getUsername())
                .userNickname(dto.getNickname())
                .userPhone(dto.getPhone())
                .userRole("USER")
                .build();

        // 저장 후 반환
        return UserRespDTO.fromEntity(userRepository.save(user));
    }

    //토큰 생성 메소드
    private String generateResetToken() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1_000_000));
    }

    // 비밀번호 재설정 요청
    @Transactional
    public boolean requestResetPwd(PwdResetReqDTO dto) {
        // 이메일 + 아이디로 찾기
        Users user = userRepository.findByUserEmail(dto.getEmail())
                .orElse(null);

        if (user == null) return false;
        if (!user.getUserId().equals(dto.getUserId())) return false;

        // 토큰 생성 (만료 시간 : 10분 뒤)
        String token = generateResetToken();
        LocalDateTime expireAt = LocalDateTime.now().plusMinutes(10);

        user.setResetToken(token);
        user.setResetTokenExpireAt(expireAt);

        return true;

    }

    // 비밀번호 재설정 확인
    @Transactional
    public boolean confirmResetPwd(PwdResetConfirmDTO dto) {
        Users user = userRepository.findByUserEmail(dto.getEmail())
                .orElse(null);

        if (user == null) return false;

        if (!user.getUserId().equals(dto.getUserId())) {
            return false;
        }

        if (user.getResetToken() == null) return false;

        if (!user.getResetToken().equals(dto.getResetToken())) {
            return false;
        }

        if (user.getResetTokenExpireAt() == null ||
                user.getResetTokenExpireAt().isBefore(LocalDateTime.now())) {
            return false;
        }

        // 비밀번호 암호화 후 저장
        String encodedPwd = passwordEncoder.encode(dto.getNewPassword());
        user.updatePassword(encodedPwd);

        //토큰 소멸
        user.setResetToken(null);
        user.setResetTokenExpireAt(null);

        return true;
    }

}

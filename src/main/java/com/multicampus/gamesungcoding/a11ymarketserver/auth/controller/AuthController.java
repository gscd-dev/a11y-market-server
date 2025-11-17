package com.multicampus.gamesungcoding.a11ymarketserver.auth.controller;

import com.multicampus.gamesungcoding.a11ymarketserver.auth.dto.*;
import com.multicampus.gamesungcoding.a11ymarketserver.auth.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/v1/auth/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO dto, HttpSession session) {
        var user = authService.login(dto);
        // 로그인 성공
        if (user != null) {
            session.setAttribute("loginUser", user);
            return ResponseEntity.ok(user); // 200 ok와 JSON 반환
        } else {
            var errBody = LoginErrResponse.builder()
                    .message("이메일 또는 비밀번호가 올바르지 않습니다.")
                    .build();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errBody);
        }
    }

    @PostMapping("/v1/auth/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "로그아웃 성공";
    }

    @PostMapping("/v1/auth/join")
    public ResponseEntity<?> join(@RequestBody @Valid JoinRequestDTO dto) {

        var savedUser = authService.join(dto);

        // 이메일 중복 시
        if (savedUser == null) {
            ErrorResponseDTO error = ErrorResponseDTO.builder()
                    .message("이미 존재하는 이메일입니다.")
                    .build();

            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }

        // 회원가입 성공 시
        JoinResponseDTO resp = JoinResponseDTO.builder()
                .msg("회원가입 성공")
                .user(savedUser)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PostMapping("/auth/password/request-reset")
    public ResponseEntity<Object> requestResetPwd(@RequestBody @Valid PwdResetReqDTO dto) {
        boolean ok = authService.requestResetPwd(dto);

        if (!ok) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("msg", "사용자 정보가 일치하지 않습니다."));
        }

        return ResponseEntity.ok(
                Map.of("msg", "비밀번호 재설정 요청 완료. 이메일을 확인해주세요.")
        );
    }

    @PostMapping("/auth/password/request-confirm")
    public ResponseEntity<Object> confirmResetPwd(@RequestBody @Valid PwdResetConfirmDTO dto) {
        boolean ok = authService.confirmResetPwd(dto);

        if (!ok) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("msg", "토큰이 유효하지 않거나 만료되었습니다."));
        }

        return ResponseEntity.ok(
                Map.of("msg", "비밀번호가 성공적으로 변경되었습니다.")
        );
    }
}


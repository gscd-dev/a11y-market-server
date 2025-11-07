package com.multicampus.gamesungcoding.a11ymarketserver.user.service;

import com.multicampus.gamesungcoding.a11ymarketserver.user.model.UserDTO;
import com.multicampus.gamesungcoding.a11ymarketserver.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // 마이페이지 - 회원 정보 조회
    @Override
    public UserDTO getUserInfo(String userId) {
        return userRepository.findById(userId)
                .map(UserDTO::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("User not no found : " + userId));
    }

    // 마이페이지 - 회원 정보 수정
    @Override
    @Transactional
    public UserDTO updateUserInfo(String userId, UserDTO userDTO) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.updateUserInfo(
                            userDTO.getUserName(),
                            userDTO.getUserEmail(),
                            userDTO.getUserPhone(),
                            userDTO.getUserNickname()
                    );
                    return UserDTO.fromEntity(user);
                })
                .orElseThrow(() -> new IllegalArgumentException("User not no found : " + userId));
    }

}

package com.multicampus.gamesungcoding.a11ymarketserver.admin.service;

import com.multicampus.gamesungcoding.a11ymarketserver.user.model.UserAdminDTO;
import com.multicampus.gamesungcoding.a11ymarketserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserManageService {
    private final UserRepository userRepository;

    public List<UserAdminDTO> listAll() {
        return userRepository.findAll()
                .stream()
                .map(UserAdminDTO::fromEntity)
                .toList();
    }

    public String changePermission(String userId, String role) {
        userRepository.findById(userId).ifPresent(user -> {
            user.changeRole(role);
            userRepository.save(user);
        });
        return "SUCCESS";
    }
}

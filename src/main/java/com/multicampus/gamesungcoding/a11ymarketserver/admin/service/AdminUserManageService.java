package com.multicampus.gamesungcoding.a11ymarketserver.admin.service;

import com.multicampus.gamesungcoding.a11ymarketserver.user.model.UserAdminDTO;

import java.util.List;

public interface AdminUserManageService {
    List<UserAdminDTO> listAll();

    String changePermission(String userId, String role);
}

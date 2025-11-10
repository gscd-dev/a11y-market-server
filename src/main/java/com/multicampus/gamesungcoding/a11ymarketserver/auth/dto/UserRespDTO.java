package com.multicampus.gamesungcoding.a11ymarketserver.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRespDTO {
    private String userId;
    private String userName;
    private String userEmail;
    private String userNickname;
    private String userRole;
}

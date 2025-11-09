package com.multicampus.gamesungcoding.a11ymarketserver.user.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Builder
public class UserAdminDTO {
    private String userId;
    private String userName;
    private String userEmail;
    private String userNickname;
    private String userRole;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date updatedAt;

    public static UserAdminDTO fromEntity(User user) {
        // 이름을 홍*동 형태로 마스킹
        String maskedName = user.getUserName();
        for (int i = 1; i < maskedName.length() - 1; i++) {
            maskedName = maskedName.replace(maskedName.charAt(i), '*');
        }

        return UserAdminDTO.builder()
                .userId(user.getUserId())
                .userName(maskedName)
                .userEmail(user.getUserEmail())
                .userNickname(user.getUserNickname())
                .userRole(user.getUserRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}

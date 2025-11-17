package com.multicampus.gamesungcoding.a11ymarketserver.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PwdResetReqDTO {

    @NotBlank(message = "사용자 ID는 필수입니다.")
    private UUID userId;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "유효한 이메일을 입력해주세요.")
    private String email;
}

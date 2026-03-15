package com.multicampus.gamesungcoding.a11ymarketserver.feature.user.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size


data class UserUpdateRequest(
    @field:Size(min = 2, max = 30, message = "사용자 이름은 2~30자 여야 합니다.")
    val userName: String?,

    @field:Email(message = "이메일 형식이 올바르지 않습니다.")
    @field:Size(max = 50)
    val userEmail: String?,

    @field:Pattern(regexp = "^\\d+$", message = "휴대폰 번호는 숫자만 있어야 합니다.")
    val userPhone: String?,

    @field:Size(min = 2, max = 20)
    val userNickname: String?
)

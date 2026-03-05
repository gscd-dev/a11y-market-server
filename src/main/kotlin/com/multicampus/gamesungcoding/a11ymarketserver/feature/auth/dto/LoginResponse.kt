package com.multicampus.gamesungcoding.a11ymarketserver.feature.auth.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.dto.UserInfo
import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.Users

data class LoginResponse(
    val user: UserInfo,
    val accessToken: String,
    val refreshToken: String
) {
    companion object {
        fun fromEntityAndTokens(user: Users, accessToken: String, refreshToken: String) =
            LoginResponse(
                user = UserInfo.fromEntity(user),
                accessToken = accessToken,
                refreshToken = refreshToken
            )
    }
}

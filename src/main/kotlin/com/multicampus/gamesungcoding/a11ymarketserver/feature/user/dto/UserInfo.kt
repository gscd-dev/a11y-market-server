package com.multicampus.gamesungcoding.a11ymarketserver.feature.user.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.UserRole
import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.Users

data class UserInfo(
    val userEmail: String,
    val userNickname: String,
    val userRole: UserRole
) {
    companion object {
        fun fromEntity(user: Users): UserInfo {
            return UserInfo(
                user.userEmail,
                user.userNickname,
                user.userRole
            )
        }
    }
}

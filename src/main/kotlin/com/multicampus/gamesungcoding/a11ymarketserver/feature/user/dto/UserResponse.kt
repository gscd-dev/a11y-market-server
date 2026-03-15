package com.multicampus.gamesungcoding.a11ymarketserver.feature.user.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.SellerSubmitStatus
import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.UserRole
import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.Users
import java.time.LocalDateTime
import java.util.*

data class UserResponse(
    val userId: UUID,
    val userName: String,
    val userEmail: String,
    val userPhone: String,
    val userNickname: String,
    val userRole: UserRole,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val sellerSubmitStatus: SellerSubmitStatus?
) {
    companion object {
        fun fromEntity(user: Users): UserResponse {
            return UserResponse(
                user.userId,
                user.userName,
                user.userEmail,
                user.userPhone,
                user.userNickname,
                user.userRole,
                user.createdAt,
                user.updatedAt,
                user.seller?.sellerSubmitStatus
            )
        }
    }
}

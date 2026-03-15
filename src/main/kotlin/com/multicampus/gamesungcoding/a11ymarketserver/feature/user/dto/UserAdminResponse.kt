package com.multicampus.gamesungcoding.a11ymarketserver.feature.user.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.UserRole
import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.Users
import java.time.LocalDateTime
import java.util.*

data class UserAdminResponse(
    val userId: UUID,
    val userName: String,
    val userEmail: String,
    val userNickname: String,
    val userRole: UserRole,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        // 향후 User 클래스로 위임 예정
        // 테스트를 위해 DTO에 추가
        fun fromEntity(user: Users): UserAdminResponse {
            // 이름을 홍*동 형태로 마스킹
            var name = user.userName
            var maskedName = when (name.length) {
                0, 1 -> name
                2 -> "${name[0]}*"
                else -> "${name[0]}${"*".repeat(name.length - 2)}${name.last()}"
            }

            return UserAdminResponse(
                userId = user.userId,
                userName = maskedName,
                userEmail = user.userEmail,
                userNickname = user.userNickname,
                userRole = user.userRole,
                createdAt = user.createdAt,
                updatedAt = user.updatedAt,
            )
        }
    }
}

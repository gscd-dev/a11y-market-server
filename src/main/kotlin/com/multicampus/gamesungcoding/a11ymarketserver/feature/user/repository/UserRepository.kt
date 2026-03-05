package com.multicampus.gamesungcoding.a11ymarketserver.feature.user.repository

import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<Users, UUID> {
    fun findByUserEmail(email: String): Users?


    fun existsByUserEmail(email: String): Boolean

    fun existsByUserPhone(userPhone: String): Boolean

    fun existsByUserNickname(nickname: String): Boolean
}

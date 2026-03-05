package com.multicampus.gamesungcoding.a11ymarketserver.feature.user.repository

import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.UserOauthLinks
import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserOauthLinksRepository : JpaRepository<UserOauthLinks, UUID> {
    fun findByOauthProviderId(providerId: String?): UserOauthLinks?

    fun existsByUser(user: Users): Boolean
}

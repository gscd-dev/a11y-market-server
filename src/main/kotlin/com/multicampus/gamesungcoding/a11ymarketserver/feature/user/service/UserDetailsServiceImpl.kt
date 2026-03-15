package com.multicampus.gamesungcoding.a11ymarketserver.feature.user.service

import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository,
) : UserDetailsService {

    @Transactional(readOnly = true)
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUserEmail(username)
            ?: throw UsernameNotFoundException("User not found with email: $username")

        val authorities = listOf<GrantedAuthority>(SimpleGrantedAuthority("ROLE_" + user.userRole))

        return User(
            user.userEmail,
            user.userPass ?: "",
            authorities
        )
    }
}

package com.multicampus.gamesungcoding.a11ymarketserver.user.repository;

import com.multicampus.gamesungcoding.a11ymarketserver.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUserEmail(String userEmail);

    boolean existsByUserEmail(String email);
}

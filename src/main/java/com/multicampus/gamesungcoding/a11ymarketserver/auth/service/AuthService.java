package com.multicampus.gamesungcoding.a11ymarketserver.auth.service;

import com.multicampus.gamesungcoding.a11ymarketserver.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private com.multicampus.gamesungcoding.a11ymarketserver.user.repository.UserRepository userRepository;

    public User login(String email, String password) {

        Optional<User> optionalUser = userRepository.findByUserEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getUserPass().equals(password)) {
                return user;
            }
        }

        return null;

    }

}

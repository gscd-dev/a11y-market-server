package com.multicampus.gamesungcoding.a11ymarketserver.auth.service;

import com.multicampus.gamesungcoding.a11ymarketserver.auth.dto.LoginDTO;
import com.multicampus.gamesungcoding.a11ymarketserver.user.model.User;
import com.multicampus.gamesungcoding.a11ymarketserver.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

//    private final PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

    public User login(LoginDTO dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();

        Optional<User> optionalUser = userRepository.findByUserEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();


//            if (passwordEncoder.matches(password, user.getUserPass())) {
//                return user;
//            }
        }

        return null;

    }

}

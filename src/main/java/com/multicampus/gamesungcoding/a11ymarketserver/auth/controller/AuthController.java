package com.multicampus.gamesungcoding.a11ymarketserver.auth.controller;

import com.multicampus.gamesungcoding.a11ymarketserver.auth.service.AuthService;
import com.multicampus.gamesungcoding.a11ymarketserver.user.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/v1/auth/login")
    @ResponseBody
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        User user = authService.login(email, password);

        if (user != null) {
            session.setAttribute("loginUser", user);
            return "로그인 성공: " + user.getUserName();
        } else {
            return "로그인 실패: 이메일 또는 비밀번호가 올바르지 않습니다.";
        }
    }

    @PostMapping("/v1/auth/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.invalidate(); //세션 무효화
        return "로그아웃 성공";
    }


}

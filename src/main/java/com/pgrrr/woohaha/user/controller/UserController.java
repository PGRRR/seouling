package com.pgrrr.woohaha.user.controller;

import com.pgrrr.woohaha.user.dto.UserJoinRequestDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public String viewSignIn(HttpSession session) {
        Object userSession = session.getAttribute("userSession");
        if (userSession == null) {
            return "/users/login";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/";
    }

    @GetMapping("/out")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/join")
    public String join(UserJoinRequestDto requestDto) {
        return "redirect:/";
    }
}

package com.pgrrr.woohaha.user.controller;

import com.pgrrr.woohaha.user.dto.UserJoinRequestDto;
import com.pgrrr.woohaha.user.dto.UserResponseDto;
import com.pgrrr.woohaha.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

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

    @GetMapping("/kakao")
    public String sns(@RequestParam(value = "code", required = false) String code, UserResponseDto responseDto, HttpSession session, Model model) {
//        String access_Token = UserService.getAccessToken(code);
//        HashMap<String, Object> userInfo = UserService.getUserInfo(access_Token);
//        String email = (String) userInfo.get("email");
        try {
//            UserResponseDto memberResponse = UserService(email);
//            session.setAttribute("memberResponse", memberResponse);
            return "redirect:/";
        } catch (NullPointerException e) {
//            String name = (String) userInfo.get("nickname");
//            String gender = (String) userInfo.get("gender");
//            responseDto.getEmail(email);
//            responseDto.getName(name);
//            responseDto.getId(gender);
            model.addAttribute("kakao", responseDto);
            return "/member/signUp";
        }
    }
}



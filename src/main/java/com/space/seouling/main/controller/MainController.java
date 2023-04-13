package com.space.seouling.main.controller;

import com.space.seouling.main.domain.TempActive;
import com.space.seouling.main.dto.TempActiveResponseDto;
import com.space.seouling.main.service.ActiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ActiveService activeService;

    @GetMapping("/")
    public String viewHome(@CookieValue(value = "stampCookie", required = false) Cookie stampCookie, HttpServletResponse response) {
        if (stampCookie != null) {
            stampCookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
            stampCookie.setPath("/");
            response.addCookie(stampCookie);
        } else {
            Cookie newStampCookie = new Cookie("stampCookie", "");
            newStampCookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
            newStampCookie.setPath("/");
            response.addCookie(newStampCookie);
        }
        return "/page/main/index";
    }

    @GetMapping("/stamp")
    public String viewStamp(@CookieValue(value = "stampCookie", required = false) Cookie stampCookie, HttpServletResponse response, Model model) {
        String stampCookieValue = "";
        if (stampCookie != null) {
            stampCookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
            stampCookie.setPath("/");
            stampCookieValue = stampCookie.getValue();
            response.addCookie(stampCookie);
        } else {
            Cookie newStampCookie = new Cookie("stampCookie", "");
            newStampCookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
            newStampCookie.setPath("/");
            response.addCookie(newStampCookie);
        }
        List<TempActive> viewActiveList = null;
        try {
            viewActiveList = activeService.viewActiveList(Arrays.stream(stampCookieValue.split("@"))
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (RuntimeException ignored) {

        }
        model.addAttribute("stampList", viewActiveList);
        return "/page/stamp/index";
    }

    @GetMapping("/stamp/{activeId}")
    public String addStamp(@PathVariable Integer activeId, @CookieValue(value = "stampCookie", required = false) Cookie stampCookie, HttpServletResponse response, Model model) {
        String stampCookieValue;
        if (stampCookie != null) {
            stampCookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
            stampCookie.setPath("/");
            if (!stampCookie.getValue().contains(activeId.toString())) {
                stampCookie.setValue(stampCookie.getValue() + "@" + activeId);
            }
            stampCookieValue = stampCookie.getValue();
            response.addCookie(stampCookie);
        } else {
            Cookie newStampCookie = new Cookie("stampCookie", "@" + activeId);
            newStampCookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
            newStampCookie.setPath("/");
            stampCookieValue = newStampCookie.getValue();
            response.addCookie(newStampCookie);
        }
        List<TempActive> viewActiveList = activeService.viewActiveList(Arrays.stream(stampCookieValue.split("@"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        model.addAttribute("stampList", viewActiveList);
        return "redirect:/stamp";
    }

    @GetMapping("/active")
    public String viewActive(Model model) {
        List<TempActiveResponseDto> activeList = activeService.viewActiveList();
        model.addAttribute("activeList", activeList);
        return "/page/active/index";
    }

    @GetMapping("/share")
    public String viewShare(@CookieValue(value = "stampCookie", required = false) Cookie stampCookie, HttpServletResponse response, Model model) {
        String stampCookieValue = "";
        if (stampCookie != null) {
            stampCookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
            stampCookie.setPath("/");
            stampCookieValue = stampCookie.getValue();
            response.addCookie(stampCookie);
        } else {
            Cookie newStampCookie = new Cookie("stampCookie", "");
            newStampCookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
            newStampCookie.setPath("/");
            response.addCookie(newStampCookie);
        }
        List<TempActive> viewActiveList = null;
        try {
            viewActiveList = activeService.viewActiveList(Arrays.stream(stampCookieValue.split("@"))
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (RuntimeException ignored) {

        }
        model.addAttribute("stampList", viewActiveList);
        return "/page/share/index";
    }

    @GetMapping("/clear")
    public String clearStamp(@CookieValue(value = "stampCookie", required = false) Cookie stampCookie, HttpServletResponse response) {
        if (stampCookie != null) {
            stampCookie.setMaxAge(0);
            response.addCookie(stampCookie);
        }
        return "redirect:/";
    }

}

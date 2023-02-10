package com.pgrrr.woohaha.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards")
public class BoardController {
    private String cleanXSS(String value) {
        return "";
    }

    @GetMapping("/list")
    public String viewList() {
        return "";
    }

    @PostMapping("/{bd_id}")
    public String write(@PathVariable Integer bd_id) {
        return "";
    }

    @PatchMapping("/{bd_id}")
    public String modify(@PathVariable Integer bd_id) {
        return "";
    }

    @DeleteMapping("/{bd_id}")
    public String delete(@PathVariable Integer bd_id) {
        return "";
    }
}


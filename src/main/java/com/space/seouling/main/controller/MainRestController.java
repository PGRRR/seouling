package com.space.seouling.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.space.seouling.main.domain.TempActive;
import com.space.seouling.main.service.ActiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainRestController {

    private final ActiveService activeService;
    @PostMapping("/add")
    public String add(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TempActive tempActive = objectMapper.readValue(json, TempActive.class);
        activeService.addActive(tempActive);
        return "redirect:/";
    }
}

package com.pgrrr.woohaha.user.dto;

import com.pgrrr.woohaha.user.domain.User;
import lombok.Getter;

import java.util.Date;

@Getter
public class UserResponseDto {
    private Integer id;
    private String email;
    private String name;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
    }
}

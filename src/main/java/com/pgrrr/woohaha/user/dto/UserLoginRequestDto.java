package com.pgrrr.woohaha.user.dto;

import com.pgrrr.woohaha.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserLoginRequestDto {
    private Integer id;
    private String email;
    private String pwd;
    private String cPwd;
    private String name;
    private Date subscription;

    @Builder
    public UserLoginRequestDto(Integer id, String email, String pwd, String cPwd, String name, Date subscription) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.cPwd = cPwd;
        this.name = name;
        this.subscription = subscription;
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .email(email)
                .pwd(pwd)
                .name(name)
                .subscription(subscription)
                .build();
    }
}

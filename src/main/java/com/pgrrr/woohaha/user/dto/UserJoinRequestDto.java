package com.pgrrr.woohaha.user.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class UserJoinRequestDto {
    private Integer id;
    private String email;
    private String pwd;
    private String cPwd;
    private String name;
    private Date subscription;
}

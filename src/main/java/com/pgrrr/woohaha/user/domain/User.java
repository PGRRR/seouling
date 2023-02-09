package com.pgrrr.woohaha.user.domain;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String pwd;
    private String name;
    private Integer point;
    private Date subscription;

    @Builder
    public User(Integer id, String email, String pwd, String name, Integer point, Date subscription) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.name = name;
        this.point = point;
        this.subscription = subscription;
    }
}

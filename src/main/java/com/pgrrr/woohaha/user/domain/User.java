package com.pgrrr.woohaha.user.domain;

import jakarta.persistence.criteria.CriteriaBuilder;
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
}

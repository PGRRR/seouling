package com.space.seouling.activity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ActivityRequestDto {

    /**
    * category
    */
    @NotNull(message = "카테고리 값이 필요합니다.")
    private String acti_cd;

    private String addr_nm;

    private Integer size = 8;

    private String sort = "from,desc";

    private String keyword;

    private String from;

    private String to;

}



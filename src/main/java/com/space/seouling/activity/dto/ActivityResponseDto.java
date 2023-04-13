package com.space.seouling.activity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ActivityResponseDto {

    private Integer acti_id;

    private String acti_cd;

    private String thmb;

    private String ttl;

    private String rpr_dsc;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime opr_prd_from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime opr_prd_to;

    private Integer avrg_rtn;

    private boolean act_yn;

}

package com.space.seouling.activity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Activity {

    private Integer acti_id;
    private String acti_cd;
    private String thmb;
    private String thmb_alt;
    private String ttl;
    private String rpr_dsc;
    private String orgn_site;
    private String opr_prd_from;
    private String opr_prd_to;
    private Integer avrg_rtn;
    private String str_addr;
    private String addr_nm;
    private String addr_crd;
    private String html_dtl;
    private boolean act_yn;

}

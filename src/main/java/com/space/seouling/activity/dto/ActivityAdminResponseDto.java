package com.space.seouling.activity.dto;

import lombok.*;
import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActivityAdminResponseDto {

    private Integer acti_id;
    private String acti_cd;
    private String thmb;
    private String thmb_alt;

//    @NotBlank(message = "제목은 필수입력 항목 입니다.")
//    @Length(min = 1, max = 150, message = "제목은 1자 이상 150자 이하로 입력 가능합니다.")
    private String ttl;

//    @NotBlank(message = "대표 설명은 필수입력 항목 입니다.")
    private String rpr_dsc;

//    @NotBlank(message = "원본 사이트 url은 필수입력 항목 입니다.")
//    @Length(min = 1, max = 150, message = "원본 사이트 url은 1자 이상 150자 이하로 입력 가능합니다.")
    private String orgn_site;

//    @NotBlank(message = "운영시간(기간)은 필수입력 항목 입니다.")
//    @Length(min = 1, max = 100, message = "운영시간(기간)은 1자 이상 100자 이하로 입력 가능합니다.")
    private Date opr_prd_from;

    private Date opr_prd_to;

//    @Min(value = 0, message = "평균 별점은 0보다 작은 값이 입력될 수 없습니다.")
    private Integer avrg_rtn;

//    @NotBlank(message = "주소는 필수입력 항목입니다.")
    private String str_addr;

//    @NotBlank(message = "주소명은 필수입력 항목입니다.")
//    @Length(min = 1, max = 100 , message = "주소명은 1자 이상 50자 이하로 입력 가능합니다.")
    private String addr_nm;

//    @NotBlank(message = "주소 좌표 값은 필수입력 항목입니다.")
//    @Length(min = 1, max = 50, message = "주소 좌표 값은 1자 이상 50자 이하로 입력 가능합니다.")
    private String addr_crd;

//    @NotBlank(message = "상세 내용은 필수입력 항목입니다.")
    private String html_dtl;


    private Integer act_yn;
    private Date frs_reg_date;
    private String frs_reg_no;
    private Date fin_mod_date;
    private String fin_mod_no;
    private String keep_yn;


    //    private String fromConverter(Date opr_prd_from){
//
//        if(opr_prd_from == null){
//            return null;
//        }else{
//            SimpleDateFormat df = new SimpleDateFormat("yyyy. MM. dd. hh:mm",Locale.KOREA);
//            String from = df.format(opr_prd_from);
//            return from;
//        }
//    }
//
//    private String toConverter(Date opr_prd_to){
//
//        if(opr_prd_from == null){
//            return null;
//        }else{
//            SimpleDateFormat df = new SimpleDateFormat("yyyy. MM. dd. hh:mm",Locale.KOREA);
//            String to = df.format(opr_prd_to);
//            return to;
//        }
//    }

}

package com.space.seouling.activity.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JsonTestDto {

    private String title;
    private String desc;
    private String period;
    private String location;
    private String inquiry;
    private String img_url;
    private String origin_url;
}

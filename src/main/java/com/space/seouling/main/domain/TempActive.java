package com.space.seouling.main.domain;

import com.space.seouling.main.dto.TempActiveResponseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TempActive {

    private Double active_id;
    private String title;
    private String content;
    private String date;
    private String thumb;

    @Builder
    public TempActive(Double active_id, String title, String content, String date, String thumb) {
        this.active_id = active_id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.thumb = thumb;
    }


    public TempActiveResponseDto toResponseDto() {
        return TempActiveResponseDto.builder()
                .active_id(this.active_id)
                .title(this.title)
                .content(this.content)
                .date(this.date)
                .thumb(this.thumb)
                .build();
    }
}

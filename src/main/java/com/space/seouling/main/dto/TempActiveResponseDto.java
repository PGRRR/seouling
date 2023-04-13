package com.space.seouling.main.dto;

import com.space.seouling.main.domain.TempActive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TempActiveResponseDto {
    private Double active_id;
    private String title;
    private String content;
    private String date;
    private Boolean isCookie;
    private String thumb;

    @Builder
    public TempActiveResponseDto(Double active_id, String title, String content, String date, Boolean isCookie, String thumb) {
        this.active_id = active_id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.isCookie = isCookie;
        this.thumb = thumb;
    }

    public TempActive toEntity() {
        return TempActive.builder()
                .active_id(this.active_id)
                .title(this.title)
                .content(this.content)
                .date(this.date)
                .thumb(this.thumb)
                .build();
    }
}

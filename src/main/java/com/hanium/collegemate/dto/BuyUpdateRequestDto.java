package com.hanium.collegemate.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BuyUpdateRequestDto {
    private String title;
    private String content;
    private String job;
    private int point;
    private String term;
    private String work;

    @Builder
    public BuyUpdateRequestDto(String title,String content,String job,int point,String term,String work){
        this.title = title;
        this.content = content;
        this.job = job;
        this.point = point;
        this.term = term;
        this.work = work;
    }
}

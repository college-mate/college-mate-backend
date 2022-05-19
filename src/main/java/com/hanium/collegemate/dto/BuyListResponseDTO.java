package com.hanium.collegemate.dto;

import com.hanium.collegemate.entity.Buy;
import lombok.Getter;

@Getter
public class BuyListResponseDTO {

    private String title;
    private String work;
    private String job;
    private String content;
    private boolean progress;
    private String term;
    private int point;
    private String date;

    public BuyListResponseDTO(Buy entity){
        this.title = entity.getTitle();
        this.work = entity.getWork();
        this.job = entity.getJob();
        this.content = entity.getContent();
        this.progress = true;
        this.term = entity.getTerm();
        this.point = entity.getPoint();
        this.date = entity.getDate();
    }

}

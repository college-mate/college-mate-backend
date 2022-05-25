package com.hanium.collegemate.dto;

import com.hanium.collegemate.entity.Buy;
import lombok.Getter;

@Getter
public class BuyListResponseDTO {

    private int idx;
    private String title;
    private String work;
    private String job;
    private String content;
    private boolean progress;
    private String term;
    private int point;
    private String date;


    public BuyListResponseDTO(Buy entity){
        this.idx = entity.getIdx();
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

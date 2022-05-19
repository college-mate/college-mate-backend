package com.hanium.collegemate.dto;

import com.hanium.collegemate.entity.Buy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class BuyDTO {

    private String title;
    private String work;
    private String job;
    private String content;
    private boolean progress;
    private String term;
    private int point;
    private String date;

    public BuyDTO(Buy entity){
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

package com.hanium.collegemate.entity;

import com.hanium.collegemate.define.EUserRole;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "buy")

public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idx;

    private String title;
    private String work;
    private String job;
    private String content;
    private boolean progress;
    private String term;
    private int point;
    private String date;

    public void update(String title,String content,String job,int point,String term,String work){
        this.title = title;
        this.content = content;
        this.job = job;
        this.point = point;
        this.term = term;
        this.work = work;
    }

}

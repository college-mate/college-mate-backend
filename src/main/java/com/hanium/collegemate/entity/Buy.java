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
    private String title;
    private String work;
    private String job;
    private String content;
    private boolean progress;
    private String term;
    private int point;
    private String date;

}

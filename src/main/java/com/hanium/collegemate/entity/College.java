package com.hanium.collegemate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "college")
public class College {
    @Id
    private String collegeName;

    private String collegeEmail;


}

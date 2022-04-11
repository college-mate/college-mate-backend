package com.hanium.collegemate.dto;

import lombok.*;

import javax.persistence.Id;


@Getter
@Setter
@ToString
@Builder
public class UserDTO {

    private String id;

    private String password;

    private String nickName;

    private String email;

    private String collegeName;

    private String phone;

    private String profileImage;

}

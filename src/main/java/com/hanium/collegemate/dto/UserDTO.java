package com.hanium.collegemate.dto;

import lombok.*;


@Getter
@Setter
@ToString
@Builder
public class UserDTO {

    private String id;

    private String password;

    private String name;

    private String email;

}

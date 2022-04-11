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
@Table(name = "user")
public class User {

    @Id
    private String id;

    private String password;

    private String nickName;

    private String email;

    private String collegeName;

    private String phone;

    private String profileImage;










    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<String> roleSet = new HashSet<>();

    public void addUserRole(EUserRole userRole){
        roleSet.add(userRole.name());
    }
}

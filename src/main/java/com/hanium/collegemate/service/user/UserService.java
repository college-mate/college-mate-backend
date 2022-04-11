package com.hanium.collegemate.service.user;

import com.hanium.collegemate.define.EUserRole;
import com.hanium.collegemate.dto.UserDTO;
import com.hanium.collegemate.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j


public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void userJoin(UserDTO dto){
        log.info("============유저 서비스 부분============");
        log.info(dto.toString());
        log.info("============정상 출력============");
        //암호화 작업
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        log.info("============암호화 후 비밀번호============");
        log.info(dto.getPassword());
        // Entity에 삽입해주기
        User newUser = new User();
        newUser.setId(dto.getId());
        newUser.setPassword(dto.getPassword());
        newUser.setNickName(dto.getNickName());
        newUser.setEmail(dto.getEmail());
        newUser.setCollegeName(dto.getCollegeName());
        newUser.setPhone(dto.getPhone());
        newUser.setProfileImage(dto.getProfileImage());
        // DB에 저장
       userRepository.save(newUser);

    }

}

package com.hanium.collegemate.controller;

import com.hanium.collegemate.dto.UserDTO;
import com.hanium.collegemate.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public void testRegister(UserDTO user) {
        log.info("========컨트롤러 부분============");
        log.info(user.toString());
        log.info("========값 정상 입력============");
        log.info("========유저 서비스로 값 전송============");
        userService.userJoin(user);
    }









        //userService.testRegister(user);
      //  userService.testRegister(user);

}

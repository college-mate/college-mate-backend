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
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/test/register")
    public void testRegister(UserDTO user) {
        log.info("==================USERCONTROLLER==================");
        log.info(user.toString());
        userService.testRegister(user);
    }









        //userService.testRegister(user);
      //  userService.testRegister(user);

}

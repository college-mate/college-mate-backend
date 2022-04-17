package com.hanium.collegemate.controller;

import com.hanium.collegemate.service.user.UserJoinOK;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import com.hanium.collegemate.dto.UserDTO;
import com.hanium.collegemate.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")

public class UserController {

    private final UserService userService;


    @PostMapping("/join")
    public ResponseEntity<String> join(@Valid UserDTO user, Errors errors) {
        return userService.userJoin(user, errors);
    }
// 중복 체크 부분
    @PostMapping("/join/{email}/emailcheck")
    public ResponseEntity<Boolean> checkEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.checkEmail(email));
    }
    // 중복 체크 부분
    @PostMapping("/join/{id}/idcheck")
    public ResponseEntity<Boolean> checkId(@PathVariable String id){
        return ResponseEntity.ok(userService.checkId(id));
    }

}
package com.hanium.collegemate.service.user;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptEngine;


@RestController
@ControllerAdvice

public class ControllerExceptionGHandler {

    @ExceptionHandler(UserValidationException.class)
    public String validationException(UserValidationException e){
        if(e.getErrorMap() == null){
            //프론트 전송 부분 / 현재는 로그로 설정
            return "에러다";
        }else{
            return "에러 전송";
        }
    }
}

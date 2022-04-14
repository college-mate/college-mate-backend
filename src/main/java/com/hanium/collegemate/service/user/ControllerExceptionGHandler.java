package com.hanium.collegemate.service.user;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptEngine;


@RestController
@ControllerAdvice
@ResponseBody

public class ControllerExceptionGHandler {

    @ExceptionHandler(UserValidationException.class)

    public Object validationException(UserValidationException e){
        if(e.getErrorMap() == null){
            //프론트 전송 부분 / 현재는 로그로 설정
            UserJoinError Error = new UserJoinError();
            Error.Respone = "Error";
            return Error;
        }else{
            UserJoinError Error = new UserJoinError();
            Error.Respone = "Error";
            return Error;
        }
    }


}

package com.hanium.collegemate.service.user;

import java.util.Map;

public class UserValidationException extends RuntimeException{
    private Map<String, String> errorMap;

    public UserValidationException(String message){
        super(message);
    }

    public UserValidationException(String message,Map<String, String> errorMap){
        super(message);
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap(){ return errorMap; }

}

package com.hanium.collegemate.service.buy;

import java.util.Map;

public class BuyValidationException extends RuntimeException{
    private Map<String, String> errorMap;

    public BuyValidationException(String message){
        super(message);
    }

    public BuyValidationException(String message,Map<String, String> errorMap){
        super(message);
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap(){ return errorMap; }

}
package com.hanium.collegemate.service.buy;

import com.hanium.collegemate.define.EUserRole;
import com.hanium.collegemate.dto.BuyDTO;
import com.hanium.collegemate.dto.BuyListResponseDTO;
import com.hanium.collegemate.entity.Buy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@ResponseBody
@RestController

public class BuyService {

    private final BuyRepository buyRepository;

    @Transactional(readOnly = true)
    public List<BuyListResponseDTO> searchAll(){
        return buyRepository.findAll().stream().map(BuyListResponseDTO::new).collect(Collectors.toList());
    }

    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

    public ResponseEntity<String> buyRegi(BuyDTO dto, Errors errors) {
        if (errors.hasErrors()) {
            Map<String, String> validatorResult = validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                log.info(validatorResult.toString());
                log.info("========오류발생============");

                BuyRegiError Error = new BuyRegiError();
                Error.Respone = "Error";
                return new ResponseEntity<>("{\"response\": \"" + Error.Respone + "\"}", HttpStatus.OK);

            }
            throw new BuyValidationException("유효성 검사 실패", validatorResult);
        } else {


            log.info("============사기 글 등록============");
            log.info(dto.toString());
            log.info("============정상 출력============");
            //암호화 작업
            // Entity에 삽입해주기
            Buy newBuy = new Buy();
            newBuy.setTitle(dto.getTitle());
            newBuy.setContent(dto.getContent());
            newBuy.setWork(dto.getWork());
            newBuy.setJob(dto.getJob());
            newBuy.setProgress(true);
            newBuy.setTerm(dto.getTerm());
            newBuy.setPoint(dto.getPoint());
            newBuy.setDate(dto.getDate());

            //준형이가 넣으라고 한거
           // newUser.addUserRole(EUserRole.USER);

            // DB에 저장
            buyRepository.save(newBuy);

            // Front로 Json값 전달
            BuyRegiOK Ok = new BuyRegiOK();
            Ok.Respone = "Ok";

            return new ResponseEntity<>("{\"response\": \"" + Ok.Respone + "\"}", HttpStatus.OK);

        }

    }

}

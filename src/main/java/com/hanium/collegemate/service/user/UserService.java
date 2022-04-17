package com.hanium.collegemate.service.user;

import com.hanium.collegemate.define.EUserRole;
import com.hanium.collegemate.dto.UserDTO;
import com.hanium.collegemate.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
@ResponseBody
@RestController
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입 시, 유효성 체크
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

    //회원가입 중복 체크 기능

    public boolean checkId(String id){
        return userRepository.existsById(id);
    }

    public boolean checkEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public ResponseEntity<String> userJoin(UserDTO dto, Errors errors) {
        if (errors.hasErrors()) {
            Map<String, String> validatorResult = validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                log.info(validatorResult.toString());
                log.info("========오류발생============");

                UserJoinError Error = new UserJoinError();
                Error.Respone = "Error";
                return new ResponseEntity<>("{\"response\": \"" + Error.Respone + "\"}", HttpStatus.OK);

            }
            throw new UserValidationException("유효성 검사 실패", validatorResult);
        } else {


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

            // Front로 Json값 전달
            UserJoinOK Ok = new UserJoinOK();
            Ok.Respone = "Ok";
            return new ResponseEntity<>("{\"response\": \"" + Ok.Respone + "\"}", HttpStatus.OK);

        }

    }

}






package com.hanium.collegemate.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hanium.collegemate.dto.BuyDTO;
import com.hanium.collegemate.dto.BuyListResponseDTO;
import com.hanium.collegemate.dto.BuyUpdateRequestDto;
import com.hanium.collegemate.entity.Buy;
import com.hanium.collegemate.service.buy.*;
import com.hanium.collegemate.service.user.UserJoinOK;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import com.hanium.collegemate.dto.UserDTO;
import com.hanium.collegemate.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@EnableWebMvc
@RequestMapping("/buy")

public class BuyController {

    private final BuyService buyService;
    private final BuyRepository buyRepository;

    //삭제
    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<String> delete(@PathVariable int idx){
        buyService.delete(idx);

        BuyDeleteOK Ok = new BuyDeleteOK();
        Ok.Respone = "Ok";

        return new ResponseEntity<>("{\"response\": \"" + Ok.Respone + "\"}", HttpStatus.OK);

    }

    //개별 조회
    @GetMapping("/read/{idx}")
    public BuyDTO searchById(@PathVariable int idx) {
        return buyService.searchById(idx);
    }

    // 전체 조회
    @GetMapping("/read")
    public List<BuyListResponseDTO> searchAll(){
        return buyService.searchAll();
    }

    // 글 생성
    @PostMapping("/reg")
    public ResponseEntity<String> reg(@Valid BuyDTO buy, Errors errors) {
        return buyService.buyRegi(buy, errors);
    }

    // 글 수정
    @PostMapping("/update/{idx}")
    public ResponseEntity<String> update(@PathVariable int idx, @RequestBody BuyUpdateRequestDto requestDto) {
        buyService.update(idx, requestDto);

        BuyUpdateOK Ok = new BuyUpdateOK();
        Ok.Respone = "Ok";

        return new ResponseEntity<>("{\"response\": \"" + Ok.Respone + "\"}", HttpStatus.OK);
    }

}

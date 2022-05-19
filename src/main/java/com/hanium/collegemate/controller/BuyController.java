package com.hanium.collegemate.controller;

import com.hanium.collegemate.dto.BuyDTO;
import com.hanium.collegemate.dto.BuyListResponseDTO;
import com.hanium.collegemate.entity.Buy;
import com.hanium.collegemate.service.buy.BuyRepository;
import com.hanium.collegemate.service.buy.BuyService;
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
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/buy")

public class BuyController {

    private final BuyService buyService;
    private final BuyRepository buyRepository;

    @GetMapping("/read")
    public List<BuyListResponseDTO> searchAll(){
        return buyService.searchAll();
    }

    @PostMapping("/reg")
    public ResponseEntity<String> reg(@Valid BuyDTO buy, Errors errors) {
        return buyService.buyRegi(buy, errors);
    }


}

package com.hanium.collegemate.service.user;

import com.hanium.collegemate.define.EUserRole;
import com.hanium.collegemate.dto.UserDTO;
import com.hanium.collegemate.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void testRegister(UserDTO dto){
        log.info("============SERVICE============");
        log.info(dto.toString());

        //암호화 작업
        User newUser = new User();
        newUser.setEmail(dto.getEmail());
        newUser.setId(dto.getId());
        newUser.setName(dto.getName());
        newUser.setPassword(dto.getPassword());

        userRepository.save(newUser);

    }

}

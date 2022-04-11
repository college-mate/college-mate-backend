package com.hanium.collegemate.security.service;

import com.hanium.collegemate.entity.User;
import com.hanium.collegemate.security.dto.AuthUserDTO;
import com.hanium.collegemate.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("User Name : " + username);

        Optional<User> result = userRepository.findById(username);
        if(result.isEmpty()){
            throw new UsernameNotFoundException("Check Your Id");
        }
        User user = result.get();

        AuthUserDTO userDTO = new AuthUserDTO(
                user.getId(),
                user.getPassword(),
                user.getRoleSet().stream().map(role -> new SimpleGrantedAuthority(
                        "ROLE_"+role
                )).collect(Collectors.toSet())
        );
       // userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}

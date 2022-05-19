package com.hanium.collegemate.service.user;

import com.hanium.collegemate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    boolean existsById(String id);
    boolean existsByEmail(String email);

}

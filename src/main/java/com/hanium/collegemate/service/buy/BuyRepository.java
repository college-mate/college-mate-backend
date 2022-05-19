package com.hanium.collegemate.service.buy;

import com.hanium.collegemate.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyRepository extends JpaRepository<Buy, Long> {

    //boolean existsByTitle(String title);
    //boolean existsByContent(String content);
    //List<Buy> findAllByOrderByTitleDesc();

}

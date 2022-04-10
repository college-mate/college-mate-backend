package com.hanium.collegemate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CollegeMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeMateApplication.class, args);
    }

}

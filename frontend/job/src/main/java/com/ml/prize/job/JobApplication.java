package com.ml.prize.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ml.prize.commons.mapper")
@SpringBootApplication(scanBasePackages = {"com.ml.prize.commons.config", "com.ml.prize.commons.util", "com.ml.prize.job.**"})
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }

}

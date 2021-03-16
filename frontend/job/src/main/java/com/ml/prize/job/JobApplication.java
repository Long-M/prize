package com.ml.prize.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ml.prize.common.mapper")
@SpringBootApplication(scanBasePackages = {"com.ml.prize.common.config", "com.ml.prize.common.util", "com.ml.prize.job.**"})
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }

}

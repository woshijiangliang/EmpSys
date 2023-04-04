package com.john.name;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableKnife4j
@MapperScan("com.john.name.domain.dao")
@SpringBootApplication
public class BabyNameApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabyNameApplication.class, args);
    }

}

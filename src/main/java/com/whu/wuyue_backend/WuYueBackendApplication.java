package com.whu.wuyue_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whu.wuyue_backend.mapper")
public class WuYueBackendApplication{

    public static void main(String[] args) {
        SpringApplication.run(WuYueBackendApplication.class, args);
    }

}

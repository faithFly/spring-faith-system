package com.faith.faithorderservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(value = "com.faith.faithorderservice.dao")
public class FaithOrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FaithOrderServiceApplication.class, args);
    }
}

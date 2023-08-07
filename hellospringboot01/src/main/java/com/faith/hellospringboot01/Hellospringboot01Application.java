package com.faith.hellospringboot01;

import com.faith.hellospringboot01.config.FeignClientConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(value = "com.faith.hellospringboot01.dao")
//@EnableFeignClients(defaultConfiguration = FeignClientConfiguration.class)
@EnableFeignClients
public class Hellospringboot01Application {
    public static void main(String[] args) {
        SpringApplication.run(Hellospringboot01Application.class, args);
        System.out.println("faith web start success!");
    }
    @Bean
    //负载均衡
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}


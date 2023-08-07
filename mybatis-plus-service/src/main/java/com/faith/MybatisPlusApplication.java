package com.faith;/**
 * @Author: faith
 * @Description: TODO
 * @DateTime: 2023/5/31 15:53
 **/

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@description:
 *@author:faith
 *@time:2023/5/3115:53
 */
@SpringBootApplication
@MapperScan("com.faith.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}

package com.faith.hellospringboot01.config;

import feign.Logger;

/**
 * @description:
 * @author:faith
 * @time:2023/5/1514:38
 */
public class FeignClientConfiguration {

    public Logger.Level feignLogLevel(){
     return Logger.Level.BASIC;
    }
}

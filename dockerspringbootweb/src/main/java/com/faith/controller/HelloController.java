package com.faith.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:faith
 * @time:2023/6/1215:09
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping("/test")
    public String helloWorld(){
        return "hello world";
    }
}

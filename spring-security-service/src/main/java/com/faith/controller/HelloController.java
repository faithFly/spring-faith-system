package com.faith.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:faith
 * @time:2023/5/1814:14
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    //@PreAuthorize("hasAuthority('test')")
    @PreAuthorize("@ex.hasAuthority('test')")
    public String hello(){
    return "hello sping security";
    }
}

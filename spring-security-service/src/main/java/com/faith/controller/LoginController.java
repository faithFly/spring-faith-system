package com.faith.controller;

import com.faith.domain.ResponseResult;
import com.faith.domain.User;
import com.faith.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:faith
 * @time:2023/5/2214:13
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginServcie;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }
}

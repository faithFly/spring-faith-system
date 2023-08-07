package com.faith.hellospringboot01.service;

import com.faith.hellospringboot01.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User getUserById(Integer id);
}

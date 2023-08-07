package com.faith.hellospringboot01.service.Impl;

import com.faith.hellospringboot01.dao.IUserMapper;
import com.faith.hellospringboot01.pojo.User;
import com.faith.hellospringboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserService implements UserService {
    @Autowired
    private IUserMapper userMapper;
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}

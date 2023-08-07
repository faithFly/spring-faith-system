package com.faith.hellospringboot01.dao;


import com.faith.hellospringboot01.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserMapper {
    public User getUserById(Integer id);
}

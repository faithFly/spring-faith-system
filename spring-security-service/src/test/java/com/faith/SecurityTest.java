package com.faith;

import com.faith.domain.User;
import com.faith.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

/**
 * @description:
 * @author:faith
 * @time:2023/5/1816:10
 */
@SpringBootTest
public class SecurityTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void Test(){
        List<User> users = userMapper.selectList(null);
       // String userId="12138";
        int userId = 12138;
        //获取订单
        //。。。。。。。。。
        //获取用户
        //。。。。。。。。。

        System.out.println(users);
    }
}

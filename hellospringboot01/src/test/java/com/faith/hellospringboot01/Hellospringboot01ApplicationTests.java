package com.faith.hellospringboot01;

import com.faith.hellospringboot01.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootTest
class Hellospringboot01ApplicationTests {
    @Value("${Dog.name}")
    private String name;
    @Test
    void contextLoads() {
        System.out.println(name);
    }
    @Test
    public void test(){
        List<User> userList = new ArrayList<>();
        User u1 = new User(1,"faith",22);
        User u2 = new User(2,"acid",22);
        User u3 = new User(3,"evil",23);
        User u4 = new User(4,"taylor",23);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        Map<Integer, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getAge));
        Set<Map.Entry<Integer, List<User>>> entries = collect.entrySet();
        for (Map.Entry m :entries){
            System.out.println(m);
        }
        System.out.println("1111");
    }
}

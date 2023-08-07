package com.faith.controller;/**
 * @Author: faith
 * @Description: TODO
 * @DateTime: 2023/5/31 16:23
 **/

import com.faith.domain.Student;
import com.faith.mapper.UserMapper;
import com.faith.service.IExceptTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@description:
 *@author:faith
 *@time:2023/5/3116:23
 */
@RestController
@RequestMapping("api/hello")
public class HelloController {
    @Autowired
    private UserMapper mapper;
    private IExceptTestService service;
    @RequestMapping("/select")
    public void select(){
        List<Student> list = mapper.selectList(null);
        for (Student s:
             list) {
            System.out.println(s);
        }
    }
    @RequestMapping("/insert")
    public void insert(){
        Student student = new Student();
        student.setStuName("aaaa");
        int insert = mapper.insert(student);
        System.out.println("1111");
    }
    @RequestMapping("/update")
    public void update(){
        Student student = new Student();
        student.setId(6L);
        student.setStuName("eeeee");
        int insert = mapper.insert(student);
        System.out.println("yes!!!!");
    }
    @RequestMapping("/test")
    public void testException(){
        service.Test01();
    }
}

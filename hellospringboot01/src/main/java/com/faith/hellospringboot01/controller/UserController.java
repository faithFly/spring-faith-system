package com.faith.hellospringboot01.controller;


import com.faith.hellospringboot01.pojo.Order;
import com.faith.hellospringboot01.pojo.User;
import com.faith.hellospringboot01.client.UserClient;
import com.faith.hellospringboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${pattern.dateformat}")
    private String dateformat;
    @Autowired
    private UserClient userClient;
    @GetMapping("/{id}")
    //@ApiOperation("根据id获取用户")
    @ResponseBody
    public User getUserById(@PathVariable Integer id){
        User userById = userMapper.getUserById(id);
        //获取订单
        //1.老版本使用url
        //String url1 = "http://localhost:9004/api/order/1";
        //2.使用feign 远程调用
        List<Order> orderListByUserId = userClient.getOrderListByUserId(1);


        //3.使用restTemplate从服务发现中获取IP地址
//        String url = "http://orderservice/api/order/"+userById.getId();
//        ResponseEntity<List<Order>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
//        });
//        List<Order> body = exchange.getBody();
        userById.setOrderList(orderListByUserId);
        return userById;
    }
    @GetMapping("/now")
    public String now(@RequestHeader("Truth") String truth){
        System.out.println(truth);
     System.out.println(dateformat);
     return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    }
}

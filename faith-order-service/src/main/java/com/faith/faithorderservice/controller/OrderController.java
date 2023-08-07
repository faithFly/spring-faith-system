package com.faith.faithorderservice.controller;
import com.faith.faithorderservice.pojo.Order;
import com.faith.faithorderservice.service.Impl.OrderServiceImpl;
import com.faith.faithorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/hello")
    public String OrderString(){
        return "hello order";
    }
    @GetMapping("/{userId}")
    public List<Order> getOrderList(@PathVariable Integer userId){
     return orderService.getOrderList(userId);
    }
}

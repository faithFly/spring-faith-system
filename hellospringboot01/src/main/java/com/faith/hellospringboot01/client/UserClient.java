package com.faith.hellospringboot01.client;

import com.faith.hellospringboot01.config.FeignClientConfiguration;
import com.faith.hellospringboot01.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("orderservice")
//局部配置
//@FeignClient(value = "orderservice",configuration = FeignClientConfiguration.class)
public interface UserClient {
    @GetMapping("/api/order/{userId}")
    List<Order> getOrderListByUserId(@PathVariable("userId") int userId);
}

package com.faith.faithorderservice.service;

import com.faith.faithorderservice.pojo.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public List<Order> getOrderList(Integer userId);
}

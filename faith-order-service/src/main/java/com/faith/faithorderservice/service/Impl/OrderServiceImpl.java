package com.faith.faithorderservice.service.Impl;

import com.faith.faithorderservice.dao.OrderMapper;
import com.faith.faithorderservice.pojo.Order;
import com.faith.faithorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> getOrderList(Integer userId) {
        return orderMapper.getOrderList(userId);
    }
}

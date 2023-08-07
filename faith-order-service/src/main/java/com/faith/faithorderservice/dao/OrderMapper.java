package com.faith.faithorderservice.dao;


import com.faith.faithorderservice.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderMapper {
    public List<Order> getOrderList(Integer userId);
}

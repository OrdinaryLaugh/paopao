package com.bjtc.service;

import com.bjtc.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectUserOrdersByUserId(Integer userId);
    List<Order> selectOrdersByItemId(Integer itemId);
    Order selectOrderByOrderId(Integer orderId);
    boolean addOrder(Order order);
    boolean addOrders(List<Order> orders);
    boolean updateOrder(Order order);
    boolean deleteOrder(Order order);
    boolean deleteOrderByOrderId(Integer orderId);

}

package com.bjtc.service;

import com.bjtc.pojo.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> selectUserOrdersByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Order> selectOrdersByItemId(Integer itemId) {
        return null;
    }

    @Override
    public Order selectOrderByOrderId(Integer orderId) {
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public boolean addOrders(List<Order> orders) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrderByOrderId(Integer orderId) {
        return false;
    }
}

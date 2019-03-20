package com.bjtc.service;

import com.bjtc.mapper.OrderItemMapper;
import com.bjtc.pojo.Order;
import com.bjtc.pojo.OrderItem;
import com.bjtc.pojo.OrderItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    OrderItemMapper orderItemMapper;
    @Override
    public List<OrderItem> selectOrderItemsByOrderId(String orderId) {
        OrderItemExample orderItemExample = new OrderItemExample();
        OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderItemMapper.selectByExample(orderItemExample);
    }

    @Override
    public List<List<OrderItem>> selectOrderItemsByOrders(List<Order> orders) {
        List<List<OrderItem>> list = new ArrayList<>();
        for (Order order : orders) {
            list.add(this.selectOrderItemsByOrderId(order.getOrderId()));
        }
        return list;
    }

    @Override
    public List<OrderItem> selectOrderItemsByItemId(Integer itemId) {
        OrderItemExample orderItemExample = new OrderItemExample();
        OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        return orderItemMapper.selectByExample(orderItemExample);
    }

    @Override
    public boolean addOrderItem(OrderItem orderItem) {
        try {
            orderItemMapper.insert(orderItem);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean addOrderItems(List<OrderItem> orderItems) {
        try {
            for (OrderItem orderItem : orderItems) {
                this.addOrderItem(orderItem);
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateOrderItem(OrderItem orderItem) {
        try {
            orderItemMapper.updateByPrimaryKey(orderItem);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteOrderItem(OrderItem orderItem) {
        return this.deleteOrderItemByOrderItemId(orderItem.getOrderItemId());
    }

    @Override
    public boolean deleteOrderItemByOrderItemId(Integer orderItemId) {
        try {
            orderItemMapper.deleteByPrimaryKey(orderItemId);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

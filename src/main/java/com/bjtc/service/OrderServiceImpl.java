package com.bjtc.service;

import com.bjtc.mapper.OrderItemMapper;
import com.bjtc.mapper.OrderMapper;
import com.bjtc.pojo.Order;
import com.bjtc.pojo.OrderExample;
import com.bjtc.pojo.OrderItem;
import com.bjtc.pojo.OrderItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public List<Order> selectUserReceiveOrdersByUserId(Integer userId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderReceiveIdEqualTo(userId);
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public List<Order> selectSellerOrdersByUserId(Integer userId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderSellerIdEqualTo(userId);
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public List<Order> selectUserBuyOrdersByUserId(Integer userId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderBuyerIdEqualTo(userId);
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public List<Order> selectOrdersByItemId(Integer itemId) {
        List<Integer> orderIds = new ArrayList<>();
        OrderExample orderExample = new OrderExample();
        OrderItemExample orderItemExample = new OrderItemExample();

        OrderExample.Criteria criteria = orderExample.createCriteria();
        OrderItemExample.Criteria criteria1 = orderItemExample.createCriteria();
        criteria1.andItemIdEqualTo(itemId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
        for (OrderItem orderItem : orderItems) {
            orderIds.add(orderItem.getOrderId());
        }
        criteria.andOrderIdIn(orderIds);
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public Order selectOrderByOrderId(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public boolean addOrder(Order order) {
        try {
            orderMapper.insert(order);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean addOrders(List<Order> orders) {
        try {
            for (Order order : orders) {
                this.addOrder(order);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateOrder(Order order) {
        try {
            orderMapper.updateByPrimaryKey(order);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteOrder(Order order) {
        try {
            orderMapper.deleteByPrimaryKey(order.getOrderId());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteOrderByOrderId(Integer orderId) {
        try {
            orderMapper.deleteByPrimaryKey(orderId);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

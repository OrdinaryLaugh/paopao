package com.bjtc.service;

import com.bjtc.pojo.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    List<Order> selectUserReceiveOrdersByUserId(Integer userId);
    List<Order> selectSellerOrdersByUserId(Integer userId);
    List<Order> selectUserBuyOrdersByUserId(Integer userId);
    List<Order> selectOrderByNumber(String number);
    List<Order> selectOrdersByItemId(Integer itemId);
    List<Order> selectByPhone(String phone);
    Order selectByOrderId(String  orderId);
    boolean addOrder(Order order);
    boolean addOrders(List<Order> orders);
    boolean updateOrder(Order order);
    boolean deleteOrder(Order order);
    boolean deleteOrderByOrderId(String orderId);

}

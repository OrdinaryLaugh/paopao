package com.bjtc.service;

import com.bjtc.pojo.Order;
import com.bjtc.pojo.User;
import org.aspectj.weaver.ast.Or;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> selectOrderByNumber(String number);

    List<Order> selectOrderByStartPage(Integer startPage);

    List<Order> selectOrdersByStatusAndPhoneAndPage(String status,String phone,Integer startPage);

    List<Order> selectOrdersByPhoneAndStatus(String status,String phone);

    List<Order> selectByPhone(String phone);

    List<Order> selectAllOrders();

    List<Order> getComplainOrders();

    List<Order> getOrdersByStatus(String status);

    List<Order> getRecentAOrders(Integer startPage);

    List<Order> getComplainOrdersByPage(Integer startPage);

    List<Order> selectOrderByPhoneAndStartPage(String phone,Integer startPage);

    List<Order> searchOrdersByContent(String searchContent);

    Order selectByOrderId(String orderId);

    List<Order> selectOrderByOrderIdAndPhoneAndTime(String orderId,String phone, String time);

    boolean addOrder(Order order);

    boolean addOrders(List<Order> orders);

    boolean updateOrder(Order order);

    boolean deleteOrder(Order order);

    boolean deleteOrderByOrderId(String orderId);

    public boolean acceptOrder(Order order, String userPhone);

    public boolean deliveredOrder(Order order);

    public boolean receivedOrder(Order order);

    public boolean complainOrder(Order order,String reason);

    public boolean complainFinsh(Order order);

    public boolean dealFailureOrder();
}
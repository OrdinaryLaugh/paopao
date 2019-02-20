package com.bjtc.service;

import com.bjtc.pojo.Order;
import com.bjtc.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> selectOrderItemsByOrderId(Integer orderId);
    List<List<OrderItem>> selectOrderItemsByOrders(List<Order> orders);
    List<OrderItem> selectOrderItemsByItemId(Integer itemId);
    boolean addOrderItem(OrderItem orderItem);
    boolean addOrderItems(List<OrderItem> orderItems);
    boolean updateOrderItem(OrderItem orderItem);
    boolean deleteOrderItem(OrderItem orderItem);
    boolean deleteOrderItemByOrderItemId(Integer orderItemId);
}

package com.bjtc.mapper;

import com.bjtc.pojo.OrderItem;

public interface OrderItemMapper {

    int deleteByPrimaryKey(Integer orderItemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);


    OrderItem selectByPrimaryKey(Integer orderItemId);

    int updateByPrimaryKey(OrderItem record);
}
package com.bjtc.mapper;

import com.bjtc.pojo.Order;
import com.bjtc.pojo.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String  orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    List<Order> selectByPhone(String phone);

    Order selectByOrderId(String orderId);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
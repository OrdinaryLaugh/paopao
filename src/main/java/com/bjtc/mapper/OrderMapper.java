package com.bjtc.mapper;

import com.bjtc.pojo.Order;

import java.util.Date;
import java.util.List;

import com.bjtc.util.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {


    int deleteByPrimaryKey(String  orderId);

    int insert(Order record);

    List<Order> selectByPhone(String phone);

    List<Order> selectOrderByPhoneAndTime(@Param("phone") String phone,@Param("time") Date time);

    List<Order> selectOrderByPhoneAndTimeAndOrderId(@Param("orderId") String orderId , @Param("phone") String phone,@Param("time") String time);

    List<Order> selectByOrderStatus(String status);

    List<Order> selectAllOrders();

    List<Order> selectOrdersByPhoneAndStatus(@Param("status") String status,@Param("phone") String phone);

    List<Order> selectOrderByStartPage(Integer startPage);

    List<Order> selectOrdersByStatusAndPhoneAndPage(@Param("orderStatus") String status,@Param("phone") String phone,@Param("startPage") Integer startPage);

    List<Order> selectOrderByStatusAndStartPage(@Param("status") String status,@Param("startPage") Integer startPage);

    List<Order> selectOrderByPhoneAndStartPage(@Param("phone") String phone,@Param("startPage") Integer startPage);

    List<Order> searchOrdersByContent(String searchContent);

    Order selectByOrderId(String orderId);

    Order selectByPrimaryKey(String orderId);
    //获取所有商家的总销售额
    Double getTotalSales();
    //根据商家手机号查询该商家的销售额
    Double getTotalSalesByPhone(String phone);
    //根据商家手机号和时间查询销量
    Double selectAmountByPhoneAndTime(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("phone") String phone);
    //根据开始时间和结束时间和地区来查询销量
    Double selectAmountByAddressAndTime(@Param("address") String address,@Param("startTime") String startTime,@Param("endTime") String endTime);
    //根据商家手机号和时间模糊查询销量
    Double selectAllAmountByPhoneLikeTime(@Param("phone") String phone,@Param("time") String time);
    //根据时间查询所有商家的总销量
    Double selectAllAmountByTime(@Param("startTime") String startTime,@Param("endTime") String endTime);
    //根据时间来模糊查询所有商家总销量
    Double selectAllAmountLikeTime(String time);
    //根据时间和地区模糊查询销量
    Double selectAmountByAddressLikeTime(@Param("address") String address,@Param("time") String time);



    int updateByPrimaryKey(Order record);
}
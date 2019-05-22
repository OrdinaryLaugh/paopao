package com.bjtc.service;

import com.bjtc.mapper.OrderItemMapper;
import com.bjtc.mapper.OrderMapper;
import com.bjtc.mapper.UserMapper;
import com.bjtc.pojo.*;
import com.bjtc.util.CheckInputUtils;
import com.bjtc.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired(required = false)
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private UserMapper userMapper;



    /**
     * 根据输入的手机号或订单号查询订单
     * @param number
     * @return
     */
    @Override
    public List<Order> selectOrderByNumber(String number) {
        boolean isOrder = CheckInputUtils.checkOrderId(number);
        List<Order> orderList=new ArrayList<>();
        if(isOrder){
            Order order = orderMapper.selectByOrderId(number);
            orderList.add(order);
            return orderList;
        }
        boolean isPhone=CheckInputUtils.checkPhone(number);
        if(isPhone){
            List<Order> orders = orderMapper.selectByPhone(number);
            orderList=orders;
            return orderList;
        }
        return orderList;
    }

    /**
     * 根据手机号（也可能是订单号）和时间查询订单，如果时间为空的话则根据传入的数字查询
     * @param time
     * @return
     */
    @Override
    public List<Order> selectOrderByOrderIdAndPhoneAndTime(String orderId,String phone,String time){
        if(phone==null&&time==null&&orderId==null){
            return null;
        }
        boolean isPhone = false;
        if(phone!=null) {
           isPhone = CheckInputUtils.checkPhone(phone);
        }
        boolean isOrder = false;
        if(orderId!=null){
            isOrder = CheckInputUtils.checkOrderId(orderId);
        }
        if(!isOrder&&!isPhone&&time==null){
            return null;
        }
        //phone和orderId可能会有数据但是格式不一定正确，所以需要进行判断
        if(isPhone&&!isOrder){
            List<Order> orders = orderMapper.selectOrderByPhoneAndTimeAndOrderId(null,phone,time);
            return orders;
        }else if(!isPhone&&isOrder){
            return orderMapper.selectOrderByPhoneAndTimeAndOrderId(orderId,null,time);
        }else if(!isOrder&&!isPhone){
            return orderMapper.selectOrderByPhoneAndTimeAndOrderId(null,null,time);
        }else {
            return orderMapper.selectOrderByPhoneAndTimeAndOrderId(orderId,phone,time);
        }
    }

    /**
     * 分页查询，根据页数查询，每次返回10条
     * @param startPage
     * @return
     */
    @Override
    public List<Order> selectOrderByStartPage(Integer startPage) {
        if(startPage==null){
            return null;
        }
        return orderMapper.selectOrderByStartPage(startPage);
    }

    @Override
    public List<Order> selectOrdersByStatusAndPhoneAndPage(String status, String phone, Integer startPage) {
        if(startPage==null||status==null||!CheckInputUtils.checkPhone(phone)){
            return null;
        }
        return orderMapper.selectOrdersByStatusAndPhoneAndPage(status,phone,startPage);
    }

    @Override
    public List<Order> selectOrdersByPhoneAndStatus(String status, String phone) {
        return orderMapper.selectOrdersByPhoneAndStatus(status,phone);
    }


    @Override
    public List<Order> selectByPhone(String phone) {
        boolean result = CheckInputUtils.checkPhone(phone);
        if(!result){
            return null;
        }
        return orderMapper.selectByPhone(phone);
    }

    @Override
    public List<Order> selectAllOrders() {
        return orderMapper.selectAllOrders();
    }

    /**
     * 获取被投诉的订单
     * @return
     */
    @Override
    public List<Order> getComplainOrders() {
        return orderMapper.selectByOrderStatus("F");
    }

    /**
     * 分页获取被投诉的订单
     * @param startPage
     * @return
     */
    @Override
    public List<Order> getComplainOrdersByPage(Integer startPage) {
        if(startPage==null){
            return null;
        }
        List<Order> orderList = orderMapper.selectOrderByStatusAndStartPage("F", startPage);
        return orderList;
    }

    /**
     * 根据订单状态获取订单
     * @param status
     * @return
     */
    @Override
    public List<Order> getOrdersByStatus(String status){
        if(status==null){
            return null;
        }
        List<Order> orderList = orderMapper.selectByOrderStatus(status);
        return orderList;
    }

    /**
     * 获取近期待代取状态订单，每次返回10条
     * @param startPage
     * @return
     */
    @Override
    public List<Order> getRecentAOrders(Integer startPage) {
        if(startPage==null){
            return null;
        }
        //先获取各种类型待代取订单，然后汇总到一个list中返回
        List<Order> orderListB = orderMapper.selectOrderByStatusAndStartPage("BA", startPage);
        List<Order> orderListP = orderMapper.selectOrderByStatusAndStartPage("PA", startPage);
        List<Order> orderListE = orderMapper.selectOrderByStatusAndStartPage("EA", startPage);
        List<Order> orderListM = orderMapper.selectOrderByStatusAndStartPage("MA", startPage);
        List<Order> orders = new ArrayList<>();
        orders.addAll(orderListB);
        orders.addAll(orderListP);
        orders.addAll(orderListE);
        orders.addAll(orderListM);
        return orders;
    }

    /**
     * 分页根据手机号获取订单
     * @param phone
     * @param startPage
     * @return
     */
    @Override
    public List<Order> selectOrderByPhoneAndStartPage(String phone, Integer startPage) {
        if(!CheckInputUtils.checkPhone(phone)||startPage==null){
            return null;
        }
        return orderMapper.selectOrderByPhoneAndStartPage(phone,startPage);
    }

    /**
     * 根据关键字模糊匹配，暂时只支持地区和大小（order_shop_address,order_size）
     * @param searchContent
     * @return
     */
    @Override
    public List<Order> searchOrdersByContent(String searchContent) {
        if(searchContent==null){
            return null;
        }
        return orderMapper.searchOrdersByContent(searchContent);
    }

    @Override
    public Order selectByOrderId(String orderId) {
        boolean result = CheckInputUtils.checkOrderId(orderId);
        if(!result){
            return null;
        }

        return orderMapper.selectByOrderId(orderId);
    }


    /**
     * 用户发布订单，订单初始状态为 待代取（BA或PA）
     * @param order
     * @return
     */
    @Transactional
    @Override
    public boolean addOrder(Order order) {
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        if(!checkOrder){
            return false;
        }
        try {
            order.setOrderCreateDate(new Date());
            int insert = orderMapper.insert(order);
            if(insert!=1){
                return false;
            }
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Transactional
    @Override
    public boolean addOrders(List<Order> orders) {
        boolean addOrders=true;
        try {
            for (Order order : orders) {
                boolean checkOrder = CheckInputUtils.checkOrder(order);
                if(!checkOrder){
                    continue;
                }
                order.setOrderCreateDate(new Date());
                addOrders&=this.addOrder(order);
            }
            if(!addOrders){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    @Override
    public boolean updateOrder(Order order) {
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        if(!checkOrder){
            return false;
        }
        try {
            order.setOrderUpdateDate(new Date());
            int update = orderMapper.updateByPrimaryKey(order);
            if(update!=1){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    @Override
    public boolean deleteOrder(Order order) {
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        if(!checkOrder){
            return false;
        }
        try {
            int delete = orderMapper.deleteByPrimaryKey(order.getOrderId());
            if(delete!=1){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteOrderByOrderId(String orderId) {
        boolean checkOrder = CheckInputUtils.checkOrderId(orderId);
        if(!checkOrder){
            return false;
        }
        try {
            int delete = orderMapper.deleteByPrimaryKey(orderId);
            if(delete!=1){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 用户接受订单，订单状态需要为 待代取（A）
     * @param order
     * @param userPhone
     * @return
     */
    @Override
    @Transactional
    public boolean acceptOrder(Order order, String userPhone){
        if(userPhone==null){
            return false;
        }
        User user = userMapper.selectByPhoneNumber(userPhone);
        if(user == null){
            return false;
        }
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        checkOrder&=CheckInputUtils.checkPhone(user.getUserPhone());
        if(order.getOrderBuyerPhone().equals(user.getUserPhone())||!checkOrder||!order.getOrderStatus().substring(1).equals("A")){
            return  false;
        }
        //骑手接单，订单状态变为代取中
        order.setOrderStatus(order.getOrderStatus().substring(0,1)+"B");
        order.setOrderReceiveId(user.getUserId());
        order.setOrderReceiveName(user.getUserName());
        order.setOrderReceivePhone(user.getUserPhone());
        int i = orderMapper.updateByPrimaryKey(order);
        if(i!=1){
            return false;
        }
        return true;
    }

    /**
     * 骑手送达，订单状态需要为 代取中（B），订单状态变为 已送达（C）
     * @param order
     * @return
     */
    @Transactional
    @Override
    public boolean deliveredOrder(Order order) {
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        if(!checkOrder||!order.getOrderStatus().substring(1).equals("B")){
            return false;
        }
        order.setOrderStatus(order.getOrderStatus().substring(0,1)+"C");
        int i = orderMapper.updateByPrimaryKey(order);
        if(i!=1){
            return false;
        }
        return true;
    }
    /**
     * 雇主已接收，订单状态需要为 已送达（C），状态变为 已接收（D），骑手在该状态可收到报酬
     * @param order
     * @return
     */
    @Override
    @Transactional
    public boolean receivedOrder(Order order) {
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        if(!checkOrder||!order.getOrderStatus().substring(1).equals("C")){
            return false;
        }
        order.setOrderStatus(order.getOrderStatus().substring(0,1)+"D");
        int i = orderMapper.updateByPrimaryKey(order);
        if(i!=1){
            return false;
        }
        return true;
    }

    /**
     * 用户投诉订单，订单状态需要为 已接收（D），状态变为 投诉中（F），逆向流程开始
     * @param order
     * @param reason 投诉原因
     * @return
     */
    @Override
    @Transactional
    public boolean complainOrder(Order order, String reason) {
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        if(!checkOrder||!order.getOrderStatus().substring(1).equals("D")){
            return false;
        }
        order.setOrderStatus("F");
        order.setOrderItemDescribe(order.getOrderItemDescribe()+";"+reason);
        int i = orderMapper.updateByPrimaryKey(order);
        if(i!=1){
            return false;
        }
        return true;
    }

    /**
     * 投诉订单处理完成，订单状态需要为 投诉中（F），状态变为 投诉处理完成（G），逆向流程结束
     * @param order
     * @return
     */
    @Override
    @Transactional
    public boolean complainFinsh(Order order) {
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        if(!checkOrder||!order.getOrderStatus().equals("F")){
            return false;
        }
        order.setOrderStatus("G");
        int i = orderMapper.updateByPrimaryKey(order);
        if(i!=1){
            return false;
        }
        return true;
    }

    /**
     * 使用定时任务处理失效订单，失效订单可能来自A，雇主的订单超过设置的最迟收货时间或订单保持待代取状态A超过一个月，自动变为Z，状态变为 失效订单（Z）
     * @return
     */
    @Override
//    @Scheduled(cron = "0 0 12 * * ?")
    @Scheduled(cron = "0 0/2 * * * ?")
    public boolean dealFailureOrder() {
        System.out.println("定时清理失效订单执行");
        List<Order> orderList = orderMapper.selectAllOrders();
        int i = 1;
        for(Order order:orderList) {
            if (!CheckInputUtils.checkOrder(order)) {
                return false;
            }

            Date date = new Date();
            //用户设置的最晚收货时间
            Date orderBuyerDate = order.getOrderBuyerDate();
            //给订单创建时间加一个月
            Date orderCreateDate = order.getOrderCreateDate();
            orderCreateDate = DateUtils.getNextMonth(orderCreateDate);
            if(orderBuyerDate==null){
                continue;
            }
            //如果当前时间晚于最晚收货时间或晚于订单创建时间一个月的话则该订单状态改为 失效订单（Z）
            if ((date.after(orderBuyerDate) || date.after(orderCreateDate))&&!order.getOrderStatus().substring(1).equals("Z")) {
                order.setOrderStatus(order.getOrderStatus().substring(0, 1) + "Z");
                i *= orderMapper.updateByPrimaryKey(order);
            }

        }
        if(i!=1){
            System.out.println("定时清理失效订单结束");
            return false;
        }
        System.out.println("定时清理失效订单结束");
        return true;
    }

    public static void main(String[] args){
        String str = "BZ";
        String str2 = "FA";
        System.out.println(null+"%");

    }

}

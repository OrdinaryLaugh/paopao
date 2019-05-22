package com.bjtc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjtc.pojo.Evaluation;
import com.bjtc.pojo.Order;
import com.bjtc.pojo.RequestData;
import com.bjtc.pojo.User;
import com.bjtc.service.EvaluationService;
import com.bjtc.service.OrderService;
import com.bjtc.util.CheckInputUtils;
import com.bjtc.util.DateUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    EvaluationService evaluationService;

    /**
     * 创建订单，订单初始状态为 待代取（BA或PA）
     * @param order
     * @param response
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/user/createOrder")
    public Map<String,String> createOrder(@RequestBody Order order, HttpServletResponse response){
        boolean isCreateOrder = orderService.addOrder(order);
        Map<String,String> map = new HashMap<>();
        if(!isCreateOrder){
            map.put("result","false");
            return map;
        }
        map.put("result","true");
        return map;
    }

    /**
     * 根据订单状态获取订单
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getOrdersByStatus")
    public List<Order> getOrdersByStatus(String status){
        List<Order> ordersByStatus = orderService.getOrdersByStatus(status);
        return ordersByStatus;
    }

    /**
     * 根据搜索关键字模糊匹配订单，暂时只支持 地区 和 大小(order_shop_address,order_size)
     * @param searchContent
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchOrdersByContent")
    public List<Order> searchOrdersByContent(String searchContent){
        List<Order> orderList = orderService.searchOrdersByContent(searchContent);
        return orderList;
    }
    /**
     * 获取近期待代取订单，每次10条
     * @param startPage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRecentAOrders")
    public List<Order> getRecentAOrders(String startPage){
        if(startPage == null){
            return  null;
        }
        List<Order> recentAOrders = orderService.getRecentAOrders(Integer.valueOf(startPage));
        return recentAOrders;
    }
    /**
     * 更新订单
     * @param order
     * @param response
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/updateOrder")
    public Map<String,String> updateOrder(@RequestBody Order order, HttpServletResponse response){
        boolean isUpdateOrder = orderService.updateOrder(order);
        Map<String,String> map = new HashMap<>();
        if(!isUpdateOrder){
            map.put("result","false");
            return map;
        }
        map.put("result","true");
        return map;
    }

    /**
     * 用户取消发布订单，订单状态第二列需要为 待代取（A），订单状态第二列变为 已取消（E）
     * @param orderId
     * @param response
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/user/cancelOrder")
    public Map<String,String>  cancelOrder( String orderId,HttpServletResponse response){
        Order order = orderService.selectByOrderId(orderId);
        boolean b =false;
        if(order.getOrderStatus().substring(1).equals("A")){
            order.setOrderStatus(order.getOrderStatus().substring(0,1)+"E");
            b = orderService.updateOrder(order);
        }
        Map<String,String> map = new HashMap<>();
        if(b) {
            map.put("result","true");
            return map;
        }else {
            map.put("result","false");
            return map;
        }
    }
    /**
     * 删除订单
     * @param orderId
     * @param response
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/deleteOrder")
    public Map<String,String> deleteOrder(@RequestBody String orderId,HttpServletResponse response){
        Order order = orderService.selectByOrderId(orderId);
        boolean delete = orderService.deleteOrder(order);
        Map<String,String> map = new HashMap<>();
        if(!delete){
            map.put("result","true");
            return map;
        }
        map.put("result","true");
        return map;
    }

    /**
     * 获取近期订单，每次从开始页返回10条
     * @param startPage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllRecentOrders")
    public Map<String,List<Order>> getAllRecentOrders(@RequestBody Map<String,String> startPage){
        if(startPage==null){
            return null;
        }
        List<Order> orderList = orderService.selectOrderByStartPage(Integer.valueOf(startPage.get("startPage")));
        Map<String,List<Order>> map = new HashMap<>();
        map.put("orders",orderList);
        return map;
    }
    /**
     * 查询所有订单
     * @param response
     * @return
     */
    @RequestMapping(value = "/findAllOrders")
    @ResponseBody
    public Object findAllOrders(HttpServletResponse response){
        List<Order> orderList = orderService.selectAllOrders();
        return orderList;
    }

    /**
     * 根据分页页数和Session中的商家信息查询近期订单
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/seller/myRecentOrders")
    public Map<String,Object> getMyRecentOrders(HttpServletRequest request,@RequestBody Map<String,String> data){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<>();
        if(session!=null){
            Object sellerPhone = session.getAttribute("sellerPhone");
            if (sellerPhone == null){
                return map;
            }
            String startPage = data.get("startPage");
            if(startPage==null){
                List<Order> orderList = orderService.selectByPhone(sellerPhone.toString());
                map.put("orders",orderList);
                return map;
            }
            Integer startPageInt = Integer.valueOf(startPage);
            List<Order> orderList = orderService.selectOrderByPhoneAndStartPage(sellerPhone.toString(), startPageInt);
            map.put("orders",orderList);
            return map;
        }
        return null;
    }

    /**
     * 分页获取商家自己的被投诉订单
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/seller/myComplainOrders")
    public Map<String,Object> getMyComplainOrders(HttpServletRequest request,@RequestBody Map<String,String> data){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<>();
        if(session!=null){
            Object sellerPhone = session.getAttribute("sellerPhone");
            if(sellerPhone == null){
                return null;
            }
            String startPage = data.get("startPage");
            if(startPage == null){
                List<Order> orderList = orderService.selectOrdersByPhoneAndStatus("F", sellerPhone.toString());
                map.put("orders",orderList);
                return map;
            }
            Integer startPageInt = Integer.valueOf(startPage);
            List<Order> orderList = orderService.selectOrdersByStatusAndPhoneAndPage("F", sellerPhone.toString(), startPageInt);
            map.put("orders",orderList);
            return map;
        }
        return null;
    }
    /**
     * 根据订单号或手机号和时间查询订单List
     * @param data
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getOrders")
    @ResponseBody
    public Map<String,Object> findOrders(@RequestBody Map<String,Object> data, HttpServletResponse response) throws IOException, ParseException {
        Map<String, Object> responseMap = new HashMap<>();
        Object orderId = data.get("orderId");
        String orderIdStr = null;
        if(orderId!=null&&!orderId.equals("")){
            orderIdStr = orderId.toString();
        }
        Object phoneNumber = data.get("phoneNumber");
        String phoneStr = null;
        if (phoneNumber!=null&&!phoneNumber.equals("")){
            phoneStr = phoneNumber.toString();
        }
        //前端传的是  2019-05-10T16:00:00.000Z 格式
        Object time = data.get("time");
        String date = null;
        if(time != null&&!time.equals("")) {
            date = DateUtils.webStringToString(time.toString());
        }
        List<Order> orderList = null;
        if(date!=null) {
            orderList = orderService.selectOrderByOrderIdAndPhoneAndTime(orderIdStr, phoneStr, date + "%");
        }else {
            orderList = orderService.selectOrderByOrderIdAndPhoneAndTime(orderIdStr, phoneStr, date );
        }
        if (orderList == null) {
            responseMap.put("message", "No orders");
            return responseMap;
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        responseMap.put("message", "success");
        responseMap.put("orders", orderList);
        return responseMap;
    }

    /**
     * 根据手机号、订单状态和页数查询订单
     * @param status
     * @param phone
     * @param startPage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findOrdersByStatusAndPhoneAndPage")
    public Map<String,List<Order>> findOrdersByStatusAndPhoneAndPage(String status,String phone,Integer startPage){
        List<Order> orderList = orderService.selectOrdersByStatusAndPhoneAndPage(status, phone, startPage);
        Map<String,List<Order>> map = new HashMap<>();
        map.put("orders",orderList);
        return map;
    }


    /**
     * 用户接受订单，订单状态需要为 待代取（BA或PA……），订单状态变为 代取中（BB或PB……）
     * @param orderId
     * @param userPhone
     * @param response
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/user/acceptOrder")
    public Map<String,String> acceptOrder(String orderId,String userPhone, HttpServletResponse response){
        Map<String,String> map = new HashMap<>();
        if(orderId == null || userPhone == null){
            map.put("result","false");
            return map;
        }
        Order order = orderService.selectByOrderId(orderId);
        boolean acceptOrder = orderService.acceptOrder(order, userPhone);
        if(!acceptOrder){
            map.put("result","false");
            return map;
        }
        map.put("result","true");
        return map;
    }

    /**
     * 骑手送达，订单状态需要为 代取中（B），状态变为 已送达（C）
     * @param orderId
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/user/deliveredOrder")
    public Map<String,String>  deliveredOrder(String orderId){
        Order order = orderService.selectByOrderId(orderId);
        boolean deliveredOrder = orderService.deliveredOrder(order);
        Map<String,String> map = new HashMap<>();
        if(deliveredOrder){
            map.put("result","true");
            return map;
        }
        else {
            map.put("result","false");
            return map;
        }
    }

    /**
     * 雇主接收，订单状态需要为 已送达（C），状态变为 已接收（已付款）（D），正向流程结束
     * @param orderId
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/user/receivedOrder")
    public Map<String,String> receivedOrder(String orderId){
        Order order = orderService.selectByOrderId(orderId);
        boolean receivedOrder = orderService.receivedOrder(order);
        Map<String,String> map = new HashMap<>();
        if(receivedOrder){
            map.put("result","true");
            return map;
        }else {
            map.put("result","false");
            return map;
        }
    }

    /**
     * 用户投诉，订单状态需要为 已接收（已付款）（D），状态变为 投诉中（F），逆向流程开始
     * @param orderId
     * @param reason 投诉原因
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/user/complainOrder")
    public Map<String,String> complainOrder(String orderId,String reason){
        Order order = orderService.selectByOrderId(orderId);
        boolean complainOrder = orderService.complainOrder(order, reason);
        Map<String,String> map = new HashMap<>();
        if(complainOrder){
            map.put("result","true");
            return map;
        }else {
            map.put("result","false");
            return map;
        }
    }

    /**
     * 分页获取被投诉的订单，每次返回10条
     * @param startPage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getComplainOrders")
    public Map<String,List<Order>> getComplainOrders(@RequestBody Integer startPage){
        List<Order> complainOrdersByPage = orderService.getComplainOrdersByPage(startPage);
        Map<String,List<Order>> map = new HashMap<>();
        map.put("orders",complainOrdersByPage);
        return map;
    }

    /**
     * 投诉订单处理完成，订单状态需要为 投诉中（F），状态变为 投诉处理完成（G），逆向流程结束
     * @param orderId
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/complainFinsh")
    public Map<String,String> complainFinsh(String orderId){
        Order order = orderService.selectByOrderId(orderId);
        boolean complainFinsh = orderService.complainFinsh(order);
        Map<String,String> map = new HashMap<>();
        map.put("result","false");
        if(complainFinsh){
            map.put("result","true");
            return map;
        }
        return map;
    }

    /**
     * 评价订单，需要订单状态为 已接收（D），状态变为 已评价（H）
     * @param evaluation
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/user/evaluateOrder")
    public Map<String,String> evaluateOrder(@RequestBody Evaluation evaluation){
        String orderId = evaluation.getOrderId();
        Order order = orderService.selectByOrderId(orderId);
        boolean checkOrder = CheckInputUtils.checkOrder(order);
        Map<String,String> map = new HashMap<>();
        if(!checkOrder){
            map.put("result","false");
            return map;
        }
        int i = evaluationService.addEvaluation(evaluation,order);
        if(i!=1){
            map.put("result","false");
            return map;
        }
        map.put("result","true");
        return map;    }

    /**
     * 获取订单评价信息
     * @param orderId
     * @return
     */
    @ResponseBody
        @RequestMapping(value = "/getEvaluationByOrderId")
        public Map<String,Object> getEvaluationByOrderId(String orderId){
            Evaluation evaluationByOrderId = evaluationService.getEvaluationByOrderId(orderId);
            Map<String,Object> map = new HashMap<>();
            if(evaluationByOrderId!=null) {
                map.put("result", "success");
                map.put("evaluation", evaluationByOrderId);
                return map;
            }
            map.put("result","false");
            map.put("evaluation",null);
            return map;
        }
    /**
     * 获取代取快递订单（待代取状态）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBringOrders")
    public List<Order> getBringOrders(){
        List<Order> ba = orderService.getOrdersByStatus("BA");
        return ba;
    }

    /**
     * 获取代发快递订单（待代取状态）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPostOrders")
    public List<Order> getPostOrders(){
        List<Order> pa = orderService.getOrdersByStatus("PA");
        return pa;
    }

    /**
     * 获取带饭订单（待代取状态）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getFoodOrders")
    public List<Order> getFoodOrders(){
        List<Order> ea = orderService.getOrdersByStatus("EA");
        return ea;
    }
    /**
     * 获取杂事代跑订单（待代取状态）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMattersOrders")
    public List<Order> getMattersOrders(){
        List<Order> ma = orderService.getOrdersByStatus("MA");
        return ma;
    }

}
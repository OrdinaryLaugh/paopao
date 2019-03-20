package com.bjtc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjtc.pojo.Admin;
import com.bjtc.pojo.Order;
import com.bjtc.pojo.RequestData;
import com.bjtc.service.AdminService;
import com.bjtc.service.OrderService;
import com.bjtc.util.CheckInputUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private OrderService orderService;
    /**
     * 普通管理员注册
     * @param phoneNumber
     * @param password
     * @return
     */
    @RequestMapping(value="/adminRegistry")
    public ModelAndView adminRegistry (String phoneNumber,String password){
        ModelAndView modelAndView = new ModelAndView();
        Admin admin=new Admin();
        admin.setAdminPhone(phoneNumber);
        admin.setAdminCreateDate(new Date());
        admin.setAdminPassword(password);
        //普通管理员
        admin.setAdminRole(0);
        Admin adminExist = adminService.selectAdminByPhone(phoneNumber);
        if(adminExist!=null){
            modelAndView.setViewName("index");
            return modelAndView;
        }
        //若注册成功,result=true
        boolean result = adminService.addAdmin(admin);
        if(result){
            modelAndView.addObject("admin",admin);
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    /**
     * 管理员登录
     * @return
     */
    @RequestMapping(value="/adminLogin")
    @ResponseBody
    public  ModelAndView userLogin (HttpServletRequest request, HttpServletResponse response, @RequestBody RequestData data ){
        ModelAndView modelAndView = new ModelAndView();
        String phoneNumber=data.getPhoneNumber();
        String password=data.getPassword();
        Admin admin = adminService.selectAdminByPhone(phoneNumber);
        if(admin==null){
            modelAndView.setViewName("index");
            return modelAndView;
        }
        if(admin.getAdminPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("adminPhone",admin.getAdminPhone());
            session.setAttribute("adminPassword",admin.getAdminPassword());
            //设置session过期时间：7天
            session.setMaxInactiveInterval(7*60*60*24*1000);
            //设置自动登录，时长为7天
            Cookie cookieUserPhone=new Cookie("adminPhone",admin.getAdminPhone());
            cookieUserPhone.setMaxAge(7*60*60*24);
            Cookie cookie=new Cookie("JSESSIONID",session.getId());
            cookie.setPath("/");
            cookie.setMaxAge(7*60*60*24);
            cookieUserPhone.setHttpOnly(true);
            cookie.setHttpOnly(true);
            response.addCookie(cookieUserPhone);
            response.addCookie(cookie);
            //给客户端返回 JessionId
            modelAndView.addObject("cookie",cookie);
            modelAndView.addObject("admin",admin);
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/findOrder")
    @ResponseBody
    public Object  findOrders(@RequestBody RequestData data ,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String number= data.getPhoneNumber();
        List<Order> orderList = orderService.selectOrderByNumber(number);
        if(orderList==null){
            response.addHeader("message","failed");
            return null;
        }
        JSONArray jsonArray=new JSONArray();
        for(Order order:orderList){
            jsonArray.add(order);
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("orders",orderList);
        response.addHeader("message","success");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonArray.toJSONString());
        response.getWriter().close();
        return "success";
    }
}

package com.bjtc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjtc.pojo.RequestData;
import com.bjtc.pojo.User;
import com.bjtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.SunHints;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @return
     */
    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public  ModelAndView userLogin (HttpServletRequest request, HttpServletResponse response,@RequestBody RequestData data ){
        ModelAndView modelAndView = new ModelAndView();
        String phoneNumber=data.getPhoneNumber();
        String password=data.getPassword();
        User user = userService.selectUserByPhoneNumber(phoneNumber);
        if(user==null){
            modelAndView.setViewName("index");
            return modelAndView;
        }
        if(user.getUserPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("userPhone",user.getUserPhone());
            session.setAttribute("userPassword",user.getUserPassword());
            //设置session过期时间：7天
            session.setMaxInactiveInterval(7*60*60*24*1000);
            //设置自动登录，时长为7天
            Cookie cookieUserPhone=new Cookie("userPhone",user.getUserPhone());
            cookieUserPhone.setMaxAge(7*60*60*24);
            Cookie cookie=new Cookie("JSESSIONID",session.getId());
            cookie.setPath("/");
            cookie.setMaxAge(7*60*60*24);
            cookie.setHttpOnly(true);
            cookieUserPhone.setHttpOnly(true);
            response.addCookie(cookieUserPhone);
            response.addCookie(cookie);
            //给客户端返回 JessionId
            modelAndView.addObject("cookie",cookie);
            modelAndView.addObject("user",user);
            modelAndView.setViewName("success");
        }
        return modelAndView;
    }

    /**
     * 用户注销
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/userLogout")
     public synchronized String userLogout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        int i=2;
        for(Cookie cookie:cookies){
            if(i==0){
                return "index";
            }
            if(cookie.getName().equals("JSESSIONID")){
                //将cookie和session都删除
                cookie.setMaxAge(0);
                request.getSession().setMaxInactiveInterval(0);
                response.addHeader("message","log out successed");
                i--;
            }
            if(cookie.getName().equals("userPhone")){
                cookie.setMaxAge(0);
                i--;
            }
        }
        response.addHeader("message","log out failed");
        return "index";
    }

    /**
     * 用户修改密码
     * @param request
     * @return
     */
    @RequestMapping(value="/userChangePassword")
    public String userChangePassword(HttpServletRequest request,HttpServletResponse response){
        String userPhone = request.getParameter("userPhone");
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("userPhone")==null||!session.getAttribute("userPhone").equals(userPhone)){
            return "login";
        }
        String userNewPassword = request.getParameter("userNewPassword");
        session.setAttribute("userPassword",userNewPassword);
        return "index";
    }

    /**
     * 用户修改个人信息
     * @param request
     * @return
     */
    @RequestMapping(value="/userChangeInfo")
    public String userChangeInfo(HttpServletRequest request,HttpServletResponse response,User user){
        if(user==null){
            return "failed";
        }
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("userPhone")!=null||!session.getAttribute("userPhone").equals(user.getUserPhone())){
            return "login";
        }
        boolean result = userService.updateUser(user);
        if(result){
            return "success";
        }
        return "failed";
    }
    /**
     * 用户注册
     * @param phoneNumber
     * @param password
     * @return
     */
    @RequestMapping(value="/userRegistry")
    public ModelAndView userRegistry (String phoneNumber,String password){
        ModelAndView modelAndView = new ModelAndView();
        User user=new User();
        user.setUserPhone(phoneNumber);
        user.setUserCreateDate(new Date());
        user.setUserPassword(password);
        User userExist = userService.selectUserByPhoneNumber(phoneNumber);
        if(userExist!=null){
            modelAndView.setViewName("index");
            return modelAndView;
        }
        //若注册成功,result=true
        boolean result = userService.addUser(user);
        if(result){
            modelAndView.addObject("user",user);
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    /**
     * 该方法是用来根据userid获取用户对象信息的并且会进行数据格式的判断，并跳转到index.jsp
     * 应该先判断是否登录（用session，该功能还未实现）
     * @param userId
     * @return
     */
    @RequestMapping(value="/getUserById")
    public  synchronized ModelAndView getUserById (Integer userId){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.selectUserById(userId);
        System.out.println(user);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 获取所有的用户（对象）信息并跳转到index.jsp
     * 应该先判断是否登录（用session，该功能还未实现）
     * @return
     */
    @RequestMapping(value="/getAllUsers")
    public synchronized ModelAndView getAllUsers (){
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.selectAllUser();
        modelAndView.addObject("users",users);
        for (User user : users) {
            System.out.println(user);
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 在进行测试
     * 应该先判断是否登录（用session，该功能还未实现，感觉应该使用IOC来进行）
     * @return
     */
    @RequestMapping(value="/deleteUsersByIds")
    public synchronized ModelAndView deleteUsersByIds (HttpServletRequest request,List<Integer> ids){
        ModelAndView modelAndView = new ModelAndView();
        userService.deleteUserByIds(ids);
        modelAndView.addObject("result","successed");
        return modelAndView;
    }

}

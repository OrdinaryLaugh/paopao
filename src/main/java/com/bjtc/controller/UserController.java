package com.bjtc.controller;

import com.bjtc.pojo.RequestData;
import com.bjtc.pojo.User;
import com.bjtc.service.UserService;
import com.bjtc.util.CheckInputUtils;
import com.bjtc.util.MD5Utils;
import com.bjtc.util.SendVaildCodeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public  Map<String,Object> userLogin (HttpServletRequest request, HttpServletResponse response,String phoneNumber,String password ){
        Map<String,Object> map = new HashMap<>();
        boolean checkPhone = CheckInputUtils.checkPhone(phoneNumber);
        if(!checkPhone){
            map.put("result","Wrong PhoneNumber");
            map.put("user",null);
            return map;
        }
        //对密码使用MD5加密
        if(password!=null) {
            password = MD5Utils.string2MD5(password);
        }
        User user = userService.selectUserByPhoneNumber(phoneNumber);
        if(user==null){
            map.put("result","User is NULL");
            map.put("user",null);
            return map;
        }
        if(user.getUserPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("userPhone",user.getUserPhone());
            session.setAttribute("userPassword",password);
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
            map.put("result","success");
            map.put("user",user);
            return map;
        }
        map.put("result","Wrong Password");
        map.put("user",null);
        return map;
    }

    /**
     * 用户通过手机号获取验证码
     * @param request
     * @param phoneNumber
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userGetSMS")
    public Map<String,String> userGetSMS(HttpServletRequest request,String phoneNumber){
        Map<String,String> map = new HashMap<>();
        boolean checkPhone = CheckInputUtils.checkPhone(phoneNumber);
        if(!checkPhone){
            map.put("result","Wrong PhoneNumber");
            map.put("sms",null);
            return map;
        }
        String sendVaildCode = SendVaildCodeUtil.sendVaildCode(phoneNumber);
        //获取的sendVaildCode 是 (SMS) 格式，所以需要去掉括号
        sendVaildCode = sendVaildCode.substring(1,sendVaildCode.length()-1);
        HttpSession session = request.getSession();
        session.setAttribute("sms",sendVaildCode);
        map.put("result","success");
        return map;
    }

    /**
     * 用户使用短信验证码注册
     * @param request
     * @param phoneNumber
     * @param sms
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/userRegistryBySMS")
    public Map<String,Object> userRegistryBySMS(HttpServletRequest request,String phoneNumber,String sms){
        Map<String,Object> map = new HashMap<>();
        boolean checkPhone = CheckInputUtils.checkPhone(phoneNumber);
        if(!checkPhone){
            map.put("result","Wrong PhoneNumber");
            map.put("user",null);
            return map;
        }
        HttpSession session = request.getSession(false);
        if(session == null){
            map.put("result","Don't have this SMS");
            map.put("user",null);
            return map;
        }
        //获取服务器存储的短信验证码
        Object smsServer = session.getAttribute("sms");
        if(!sms.equals(smsServer)){
            map.put("result","Wrong SMS");
            map.put("user",null);
            return map;
        }
        User userExist = userService.selectUserByPhoneNumber(phoneNumber);
        if(userExist!=null){
            map.put("result","User is Exist");
            map.put("user",null);
            return map;
        }
        User user = new User();
        user.setUserPhone(phoneNumber);
        user.setUserCreateDate(new Date());
        user.setUserPassword(MD5Utils.string2MD5("123456"));
        boolean addUser = userService.addUser(user);
        if(addUser){
            map.put("result","success");
            map.put("user",user);
            return map;
        }
        map.put("result","Registry Failed");
        map.put("user",null);
        return map;
    }
    /**
     * 用户使用短信验证码登录
     * @return
     */
    @RequestMapping(value="/userLoginBySMS",method = RequestMethod.POST)
    @ResponseBody
    public  Map<String,Object> userLoginBySMS (HttpServletRequest request, HttpServletResponse response,String phoneNumber,String sms){
        Map<String,Object> map = new HashMap<>();
        boolean checkPhone = CheckInputUtils.checkPhone(phoneNumber);
        if(!checkPhone){
            map.put("result","Wrong PhoneNumber");
            map.put("user",null);
            return map;
        }
        HttpSession session = request.getSession(false);
        if(session == null){
            map.put("result","Don't have this SMS");
            map.put("user",null);
            return map;
        }
        //获取服务器存储的短信验证码
        Object smsServer = session.getAttribute("sms");
        if(!sms.equals(smsServer)){
            map.put("result","Wrong SMS");
            map.put("user",null);
            return map;
        }

        User user = userService.selectUserByPhoneNumber(phoneNumber);
        if(user==null){
            map.put("result","User is NULL");
            map.put("user",null);
            return map;
        }
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
        map.put("result","success");
        map.put("user",user);
        return map;
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value="/userLogout")
     public synchronized Map<String,String> userLogout(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Map<String,String> map = new HashMap<>();
        int i=2;
        for(Cookie cookie:cookies){
            if(i==0){
                map.put("result","Not Login");
                return map;
            }
            if(cookie.getName().equals("JSESSIONID")){
                //将cookie和session都删除
                cookie.setMaxAge(0);
                request.getSession().setMaxInactiveInterval(0);
                map.put("result","success");
                i--;
            }
            if(cookie.getName().equals("userPhone")){
                cookie.setMaxAge(0);
                i--;
            }
        }
        map.put("result","false");
        return map;
    }

    /**
     * 用户修改密码
     * @param request
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value="/userChangePassword")
    public Map<String,String> userChangePassword(HttpServletRequest request,HttpServletResponse response){
        Map<String,String> map = new HashMap<>();
        String userPhone = request.getParameter("userPhone");
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("userPhone")==null||!session.getAttribute("userPhone").toString().equals(userPhone)){
            map.put("result","false");
            return map;
        }
        String userNewPassword = request.getParameter("userNewPassword");
        //对密码进行MD5加密
        userNewPassword = MD5Utils.string2MD5(userNewPassword);
        session.setAttribute("userPassword",userNewPassword);
        map.put("result","success");
        return map;
    }

    /**
     * 用户修改个人信息
     * @param request
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value="/userChangeInfo")
    public Map<String,Object> userChangeInfo(HttpServletRequest request,HttpServletResponse response,@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        if(user==null){
            map.put("result","false");
            return map;
        }
        //对密码进行加密
        user.setUserPassword(MD5Utils.string2MD5(user.getUserPassword()));
        boolean result = userService.updateUser(user);
        if(result){
            map.put("result","success");
            HttpSession session = request.getSession(false);
            if(session!=null) {
                session.setAttribute("userPhone",user.getUserPhone());
                session.setAttribute("userPassword", user.getUserPassword());
            }
            return map;
        }
        map.put("result","false");
        return map;
    }
    /**
     * 用户注册
     * @param phoneNumber
     * @param password
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value="/userRegistry")
    public Map<String,Object> userRegistry (String phoneNumber,String password){
        Map<String,Object> map = new HashMap<>();
        boolean checkPhone = CheckInputUtils.checkPhone(phoneNumber);
        if(!checkPhone){
            map.put("result","Wrong PhoneNumber");
            map.put("user",null);
            return map;
        }
        User user=new User();
        user.setUserPhone(phoneNumber);
        user.setUserCreateDate(new Date());
        //对密码使用MD5加密
        password = MD5Utils.string2MD5(password);
        user.setUserPassword(password);
        User userExist = userService.selectUserByPhoneNumber(phoneNumber);
        if(userExist!=null){
            map.put("result","User is Exist");
            map.put("user",null);
            return map;
        }
        //若注册成功,result=true
        boolean result = userService.addUser(user);
        if(result){
            map.put("result","success");
            map.put("user",user);
        }
        return map;
    }

    /**
     * 该方法是用来根据userid获取用户对象信息的并且会进行数据格式的判断，并跳转到index.jsp
     * 应该先判断是否登录（用session，该功能还未实现）
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getUserById")
    public  synchronized Map<String,User> getUserById (Integer userId){
        Map<String,User> map = new HashMap<>();
        User user = userService.selectUserById(userId);
        map.put("user",user);
        return map;
    }

    /**
     * 获取所有的用户（对象）信息
     * 应该先判断是否登录
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getAllUsers")
    public synchronized Map<String,List<User>> getAllUsers (){
        Map<String,List<User>> map = new HashMap<>();
        List<User> users = userService.selectAllUser();
        map.put("users",users);
        return map;
    }

    /**
     * 在进行测试
     * 应该先判断是否登录（用session，该功能还未实现，感觉应该使用IOC来进行）
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deleteUserById")
    public Map<String,String> deleteUserById (HttpServletRequest request,@RequestBody Map<String,String> userInfo){
        String userId = userInfo.get("userId");
        boolean deleteUserById = userService.deleteUserById(userId);
        Map<String,String> map = new HashMap<>();
        if(deleteUserById){
            map.put("result","success");
            return map;
        }
        map.put("result","false");
        return map;
    }

}

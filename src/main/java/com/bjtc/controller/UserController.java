package com.bjtc.controller;

import com.alibaba.fastjson.JSON;
import com.bjtc.pojo.User;
import com.bjtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.SunHints;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private ModelAndView modelAndView = new ModelAndView();

    /**
     * 该方法是用来根据userid获取用户对象信息的并且会进行数据格式的判断，并跳转到index.jsp
     * 应该先判断是否登录（用session，该功能还未实现）
     * @param userId
     * @return
     */
    @RequestMapping(value="/getUserById")
    public ModelAndView getUserById (Integer userId){

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
    public ModelAndView getAllUsers (){
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
    public ModelAndView deleteUsersByIds (JSON json){

        Integer[] Ids = {1,2,3,4,5,6};
        List<Integer> ids = new ArrayList<Integer>();
        ids.addAll(Arrays.asList(Ids));
        System.out.println("asdf");
        for (Integer id : ids) {
            System.out.println(id);
        }
        return modelAndView;
    }
}

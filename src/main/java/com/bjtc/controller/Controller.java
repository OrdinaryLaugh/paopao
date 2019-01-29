package com.bjtc.controller;

import com.bjtc.pojo.User;
import com.bjtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.SunHints;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private UserService userService;
    private ModelAndView modelAndView = new ModelAndView();
    @RequestMapping(value="/getUserById")
    public ModelAndView getUserById (int userid){
        User user = userService.selectUserByid(userid);
        System.out.println(user);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("index");
        return modelAndView;
    }
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
}

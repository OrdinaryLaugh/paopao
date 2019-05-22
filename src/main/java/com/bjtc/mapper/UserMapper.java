package com.bjtc.mapper;

import com.bjtc.pojo.User;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UserMapper {


    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    List<User> selectAllUsers();

    User selectByPrimaryKey(Integer userId);

    User selectByPhoneNumber(String phoneNumber);


    int updateByPrimaryKey(User record);
}
package com.bjtc.dao;

import com.bjtc.mapper.UserMapper;
import com.bjtc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(Object o){
        if(o instanceof Integer){
            Integer id = (Integer)o;
            System.out.println(o);
            return userMapper.selectByPrimaryKey(id);
        }else{
            System.out.println("非法类型");
            return null;
        }
    }
}

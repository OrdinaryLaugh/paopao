package com.bjtc.service;

import com.bjtc.mapper.UserMapper;
import com.bjtc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(Object o){
        if(o instanceof Integer){
            Integer id = (Integer)o;
            System.out.println(o);
            return userMapper.selectByPrimaryKey(id);
        }else{
            System.out.println("Error Id");
            return null;
        }
    }

    @Override
    public User selectUserByPhoneNumber(String phoneNumber) {
       return userMapper.selectByPhoneNumber(phoneNumber);
    }


    @Override
    public List<User> selectAllUser() {
        List<User> users = userMapper.selectAllUsers();
        return users;
    }

    @Override
    @Transactional
    public boolean deleteUserById(Object o) {
        if(o instanceof Integer){
            Integer id = (Integer)o;
            System.out.println(o);
            userMapper.deleteByPrimaryKey(id);
            return true;
        }else{
            System.out.println("非法类型");
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteUserByIds(List<Integer> ids) {
        if(ids.isEmpty()){
            return false;
        }else{
            for(Integer id:ids){
                userMapper.deleteByPrimaryKey(id);
            }
            return true;
        }
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        try {
            userMapper.insert(user);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional
    public boolean addUsers(List<User> users) {
        try {
            for (User user : users) {
                this.addUser(user);
            }
            return true;
        }catch (Exception e){
            return  false;
        }

    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        try {
            userMapper.updateByPrimaryKey(user);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    @Transactional
    public boolean updateUsers(List<User> users) {
        try {
            for (User user : users) {
                this.updateUser(user);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

package com.bjtc.service;

import com.bjtc.mapper.UserMapper;
import com.bjtc.pojo.User;
import com.bjtc.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            System.out.println("非法类型");
            return null;
        }
    }

    @Override
    public User selectUserByPhoneNumber(String phoneNumber) {
       return userMapper.selectByPhoneNumber(phoneNumber);
    }

    @Override
    public List<User> selectUserByKey(String key) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameLike(key);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public List<User> selectAllUser() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdIsNotNull();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
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
    public boolean deleteUserByIds(List<Integer> ids) {
        if(ids.isEmpty()){
            return false;
        }else{
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserIdIn(ids);
            userMapper.deleteByExample(userExample);
            return true;
        }
    }

    @Override
    public boolean addUser(User user) {
        try {
            userMapper.insert(user);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
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
    public boolean updateUser(User user) {
        try {
            userMapper.updateByPrimaryKey(user);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
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

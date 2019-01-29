package com.bjtc.service;

import com.bjtc.dao.UserDao;
import com.bjtc.dao.UserDaoImpl;
import com.bjtc.mapper.UserMapper;
import com.bjtc.pojo.User;
import com.bjtc.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAllUser() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdIsNotNull();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public User selectUserByid(int id) {
        return userDao.selectUserById(id);
    }
}

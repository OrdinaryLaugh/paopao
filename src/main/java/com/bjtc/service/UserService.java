package com.bjtc.service;

import com.bjtc.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUser();
    User selectUserById(Object id);
    User selectUserByPhoneNumber(String phoneNumber);
    List<User> selectUserByKey(String key);
    boolean deleteUserById(Object id);
    boolean deleteUserByIds(List<Integer> ids);
    boolean addUser(User user);
    boolean addUsers(List<User> users);
    boolean updateUser(User user);
    boolean updateUsers(List<User> users);
}

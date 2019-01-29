package com.bjtc.service;

import com.bjtc.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUser();
    User selectUserByid(int id);
}

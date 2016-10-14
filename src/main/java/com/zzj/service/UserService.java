package com.zzj.service;

import com.zzj.model.User;

import java.util.List;

/**
 * Created by zhangzj on 2016/10/13.
 */
public interface UserService {

    User getUser(Integer userId);

    List<User> getUsers();

    Integer addUser(User user);

    Integer deleteUser(Integer userId);

    Integer updateUser(User user);
}

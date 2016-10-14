package com.zzj.service;

import com.zzj.dao.UserMapper;
import com.zzj.model.User;
import com.zzj.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangzj on 2016/10/13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> getUsers() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public Integer addUser(User user) {

        return userMapper.insert(user);
//        return user.getUserId();
    }

    @Override
    public Integer deleteUser(Integer userId) {

        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }


}

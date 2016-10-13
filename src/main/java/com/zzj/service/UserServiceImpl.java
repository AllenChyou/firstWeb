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
}

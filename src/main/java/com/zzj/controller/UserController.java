package com.zzj.controller;

import com.zzj.model.User;
import com.zzj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzj on 2016/10/13.
 */

@Controller
@RequestMapping(value = "/mgt")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity getUsers(HttpServletRequest request, Model model) {
        Map<String, Object> rsp = new HashMap<String, Object>();
        List<User> userList = userService.getUsers();
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : userList) {
            stringBuilder.append(user.getUserId() + " : " + user.getUserName() + "\n");
        }
        return ResponseEntity.ok(stringBuilder.toString());
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(HttpServletRequest request, Model model, @PathVariable("id") Integer userId) {
        Map<String, Object> rsp = new HashMap<String, Object>();
        User user = userService.getUser(userId);
        rsp.put("userId", user.getUserId());
        rsp.put("userName", user.getUserName());

        return ResponseEntity.ok(rsp.toString());
    }
}

package com.zzj.controller;

import com.zzj.model.User;
import com.zzj.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(HttpServletRequest request, Model model) {
        Map<String, Object> rsp = new HashMap<>();
        List<User> userList = userService.getUsers();

        rsp.put("error", 0);
        rsp.put("data", userList);
        logger.info("getUsers");
        return ResponseEntity.ok(rsp);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(HttpServletRequest request, Model model, @PathVariable("id") Integer userId) {
        Map<String, Object> rsp = new HashMap();
        User user = userService.getUser(userId);

        rsp.put("userId", user.getUserId());
        rsp.put("userName", user.getUserName());
        logger.info("getUserByID");
        return ResponseEntity.ok(rsp);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User bodyUser) {
        Map<String, Object> rsp = new HashMap();
        User user = new User();
        user.setUserId(bodyUser.getUserId());
        user.setUserName(bodyUser.getUserName());
        int result = userService.addUser(user);

        rsp.put("error", result);
        return ResponseEntity.ok(rsp);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Integer userId) {
        Map<String, Object> rsp = new HashMap();

        int result = userService.deleteUser(userId);
        rsp.put("error", result);
        return ResponseEntity.ok(rsp);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@RequestBody User bodyUser){
        Map<String, Object> rsp = new HashMap();

        User user = new User();
        user.setUserId(bodyUser.getUserId());
        user.setUserName(bodyUser.getUserName());

        int result = userService.updateUser(user);

        rsp.put("error", result);
        return ResponseEntity.ok(rsp);
    }
}

package com.mongo.cn.demo.controller;

import com.mongo.cn.demo.bean.User;
import com.mongo.cn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2019/4/12 0012下午 9:59
 */

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public User saveUser(User user){
        userService.saveUser(user);
        return user;
    }

    @RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET})
    public User updateUser(User user){
        userService.update(user);
        return user;
    }

    @RequestMapping("getUser")
    public User getUser(Long id) {
        User user = userService.getUser(id);
        return user;
    }

    @RequestMapping("getUsers")
    public List<User> getUsers(String userName, String note, Integer skip, Integer limit) {
        List<User> userList = userService.findUsers(userName, note, skip, limit);
        return userList;
    }

    @RequestMapping("delete")
    public int deleteUser(Long id) {
        return userService.deleteUser(id);
    }

}

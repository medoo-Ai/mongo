package com.mongo.cn.demo.service;

import com.mongo.cn.demo.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserService {
    int saveUser(User user);

    User getUser(Long id);

    int update(User user);

    List<User> findUsers(String userName, String note, Integer skip, Integer limit);

    int deleteUser(Long id);
}

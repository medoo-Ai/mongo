package com.mongo.cn.demo.service;

import com.mongo.cn.demo.bean.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.stereotype.Component;

import java.util.List;



public interface UserService {
    int saveUser(User user);

    User getUser(Long id);

    UpdateResult update(User user);

    List<User> findUsers(String userName, String note, Integer skip, Integer limit);

    DeleteResult deleteUser(Long id);
}

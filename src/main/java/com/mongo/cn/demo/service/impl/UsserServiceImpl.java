package com.mongo.cn.demo.service.impl;

import com.mongo.cn.demo.bean.User;
import com.mongo.cn.demo.service.UserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2019/4/12 0012下午 10:16
 */
@Component
public class UsserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int saveUser(User user) {
        User save = mongoTemplate.save(user);
        if (user!=null) {
            return 1;
        }
        return 0;
    }

    @Override
    public User getUser(Long id) {
        return  mongoTemplate.findById(id, User.class);
    }

    @Override
    public UpdateResult update(User user) {
        Criteria criteria = Criteria.where("id").is(user.getId());
        Update update = Update.update("userName", user.getUserName());
        Query query = Query.query(criteria);
        update.set("note", user.getNote());
        return this.mongoTemplate.updateFirst(query, update, User.class);
    }

    @Override
    public List<User> findUsers(String userName, String note, Integer skip, Integer limit) {
        Criteria regex = Criteria.where("userName").regex(userName).and("note").regex(note);
        // 跳过 sikp  个,  返回  limit 个
        Query query = Query.query(regex).skip(skip).limit(limit);
        return this.mongoTemplate.find(query, User.class);
    }

    @Override
    public DeleteResult deleteUser(Long id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);
        return this.mongoTemplate.remove(query, User.class);
    }
}

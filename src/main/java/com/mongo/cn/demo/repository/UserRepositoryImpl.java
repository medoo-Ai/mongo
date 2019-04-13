package com.mongo.cn.demo.repository;

import com.mongo.cn.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @auther SyntacticSugar
 * @data 2019/4/13 0013上午 10:35
 */
@Repository
public class UserRepositoryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public User findUserByIdOrUserName(Long id, String userName) {
        //  使用criteria  创建
        Criteria criteriaId = Criteria.where("id").is(id);
        Criteria criteriaUserName = Criteria.where("userName").is(userName);
        Criteria criteria = new Criteria();
        // 使用$or
        criteria.orOperator(criteriaId, criteriaUserName);
        Query query = Query.query(criteria);
        return mongoTemplate.findOne(query, User.class);
    }
}

package com.mongo.cn.demo.repository;

import com.mongo.cn.demo.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2019/4/13 0013上午 10:19
 */
@Repository
public interface UserRepositories  extends MongoRepository<User,Long> {

    List<User> findUsersByNameLike(String userName);

    @Query("{'uid':?0,'userName':?1}")
    User findUser (Long uid, String userName);
    // 自定义的方法
    User findUserByIdOrUserName(Long id,String userName);

}

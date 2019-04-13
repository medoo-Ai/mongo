package com.mongo.cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.mongo.cn.demo")
@EnableMongoRepositories(basePackages = "com.mongo.cn.demo.repository",
// 自定义的后缀  Impl
repositoryImplementationPostfix = "Impl"
)
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

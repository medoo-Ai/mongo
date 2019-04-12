package com.mongo.cn.demo.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2019/4/12 0012下午 9:35
 */
@Data
@Document
public class User implements Serializable {

    private static final long serialVersionUID = -1103907117347528477L;
    @Id
    private Long id;
    private String userName;
    private String note = null;
    private List<Role> roles = null;

}

package com.mongo.cn.demo.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @auther SyntacticSugar
 * @data 2019/4/12 0012下午 9:34
 */

@Data
@Document
public class Role  implements Serializable {

    private static final long serialVersionUID = 2257448399811909293L;
    @Id
    private Long id;
    @Field("role_name")
    private String roleName = null;
    private String note = null;
}

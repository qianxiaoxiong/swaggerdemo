package com.swaggerdemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * tb_user
 * @author 
 */

@Data

public class User implements Serializable {
    private Long id;

    private String username;

    private Integer age;

    private Byte sex;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }
}
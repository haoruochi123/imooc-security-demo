package com.imooc.user.entity;

import java.util.List;

/**
 * @Author: ruochi.hao
 * @CreateTime: 17:30 2019/6/30/030
 * @Description: 用户表
 */
public class User {

    private String id;

    private String name;

    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

package com.imooc.user.entity;

/**
 * @Author: ruochi.hao
 * @CreateTime: 17:30 2019/6/30/030
 * @Description: 角色表
 */
public class Role {

    private String id;

    private String role;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

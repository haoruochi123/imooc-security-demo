package com.imooc.user.service;

import com.imooc.user.entity.User;

import java.util.List;

/**
 * @Author: ruochi.hao
 * @CreateTime: 21:31 2019/6/30/030
 * @Description:
 */
public interface UserService {

    List<User> query(User user);
}

package com.imooc.user.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imooc.user.dao.UserDao;
import com.imooc.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ruochi.hao
 * @CreateTime: 21:31 2019/6/30/030
 * @Description:
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> query(User user) {
        Page<Object> objects = PageHelper.startPage(1, 2);
        List<User> query = userDao.query(user);
        return query;
    }
}

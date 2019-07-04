package com.imooc.user.dao;

import com.imooc.user.entity.Role;
import com.imooc.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserDao {

    /**
     * @Author: 郝若池
     * @CreateTime: 2019/7/1/001 21:56
     * @params: [user]
     * @return: java.util.List<com.imooc.user.entity.User>
     * @Description:
     */
    List<User> query(User user);

    List<Role> getByUserId(String id);

}

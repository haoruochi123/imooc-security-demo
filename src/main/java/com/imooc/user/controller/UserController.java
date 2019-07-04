package com.imooc.user.controller;

import com.imooc.user.entity.User;
import com.imooc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ruochi.hao
 * @CreateTime: 21:32 2019/6/30/030
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public void query(){
       User user =  new User();
//       user.setId("user_1");
//       user.setName("tianxuebin");
        List<User> query = userService.query(user);
        System.out.println("----------------");

    }
}

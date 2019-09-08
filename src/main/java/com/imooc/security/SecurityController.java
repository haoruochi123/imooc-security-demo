package com.imooc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 郝若池
 * @title: SecurityController
 * @description: TODO
 * @date 2019/9/8/008 11:28
 */
@RestController
@RequestMapping("/user")
public class SecurityController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @PostMapping("/regist")
    public void regist(RegistUser registUser, HttpServletRequest request) {

        //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
        String userId = registUser.getPhone();
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
    }

    @GetMapping("/me")
    public void me( HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails principal = (UserDetails) authentication.getPrincipal();
        System.out.println(principal);
    }
}

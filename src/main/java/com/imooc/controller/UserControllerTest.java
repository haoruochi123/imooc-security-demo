package com.imooc.controller;

import com.imooc.async.DeferredResultHodler;
import com.imooc.async.QueueOrder;
import com.imooc.entity.User;
import com.imooc.exception.ControllerException;
import com.imooc.validation.Inser;
import com.imooc.validation.Update;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@RestController
public class UserControllerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PutMapping("/put")
    public String update(@RequestParam(value = "username", required = true) String idname) {
        return idname;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String idname) {
        return idname;
    }

    @PostMapping(value = "/post")
    public void post(@Validated(value = {Update.class}) @RequestBody User user,BindingResult errors, Pageable pageable ) {
        if (errors.hasErrors()) {
            System.out.println("dasdasdasdadasdas");
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort().toString());
    }

    @PostMapping("/exception")
    public void exception(@Validated(value = {Inser.class}) @RequestBody  User user) {

        throw new ControllerException("APP001","调用exception出错了");
    }

    @GetMapping("/exception1")
    public void exception1(@RequestParam("name") String name) {
        throw new RuntimeException("控制层拦截测试1");
    }


    @Autowired
    private DeferredResultHodler deferredResultHodler;
    @Autowired
    private QueueOrder queueOrder;

    @GetMapping("/asyc")
    public DeferredResult<String> asyc() throws InterruptedException {
        logger.info("主线程开始");

        /*
         * Callable<String> callable = new Callable<String>() {
         *
         * @Override public String call() throws Exception { logger.info("副线程开始");
         * Thread.sleep(2000); logger.info("副线程开始"); return "success"; } };
         */

        String placeOrder = RandomStringUtils.randomNumeric(8);
        DeferredResult<String> deferredResult = new DeferredResult<String>();

        queueOrder.setPlaceOrder(placeOrder);
        deferredResultHodler.getMap().put(placeOrder, deferredResult);


        logger.info("主线程结束");

        return deferredResult;
    }

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @GetMapping("/test1")
    public void test1(HttpServletRequest request, HttpServletResponse response) {
        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
            System.out.println(cookie.getMaxAge());
        }

        Enumeration<String> attributeNames = request.getSession().getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            System.out.println("session:" + attributeNames.nextElement());
        }
        System.out.println();
        System.out.println("-------" + persistentTokenRepository.getTokenForSeries("laWa9HHQIE/p/9PEbVGhow==").getTokenValue());
    }
}

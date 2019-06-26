package com.imooc.controller;

import java.util.Enumeration;
import java.util.concurrent.Callable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreInvocationAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.imooc.async.DeferredResultHodler;
import com.imooc.async.QueueOrder;
import com.imooc.entity.User;
import com.imooc.exception.ControllerException;

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
	public void post(@Valid @RequestBody User user, Pageable pageable, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("dasdasdasdadasdas");
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}

		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getSort().toString());
	}

	@GetMapping("/exception")
	public void exception(@RequestParam("name") String name) {
		throw new ControllerException(name);
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
	public void test1(HttpServletRequest request,HttpServletResponse response) {
		for (Cookie cookie : request.getCookies()) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getMaxAge());
		}
		
		Enumeration<String> attributeNames = request.getSession().getAttributeNames();
		
		while(attributeNames.hasMoreElements()) {
			System.out.println("session:"+attributeNames.nextElement());
		}
		System.out.println(attribute);
		System.out.println("-------"+persistentTokenRepository.getTokenForSeries("laWa9HHQIE/p/9PEbVGhow==").getTokenValue());
	}
}

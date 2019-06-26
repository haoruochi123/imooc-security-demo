package com.imooc.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimeAspect {
	
	@Pointcut("execution(* com.imooc.controller.UserControllerTest.*(..))")
	private void test() {}
	
	@Around("test()")
	public Object timeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = new Date().getTime();
		System.err.println("aspect start:"+start);
		Object[] args = proceedingJoinPoint.getArgs();
		for (Object object : args) {
			System.err.println("arg:"+object);
		}
		Object proceed = proceedingJoinPoint.proceed();
		
		System.err.println("aspect end:"+(new Date().getTime()-start));
		return proceed;
	}
}

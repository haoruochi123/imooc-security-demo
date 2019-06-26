package com.imooc.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 拦截控制层抛出的错误并设置返回除外格式
 * @author Administrator
 *
 */
@ControllerAdvice
public class ControllerExceptionHandle {
	
	@ExceptionHandler(ControllerException.class)
	@ResponseBody
	@ResponseStatus()
	public Map<String, Object> name(ControllerException cException) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", cException.getName());
		map.put("message", cException.getMessage());
		return map ;
	}

}

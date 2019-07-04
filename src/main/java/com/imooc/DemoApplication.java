/**
 * 
 */
package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 *
 */
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class DemoApplication extends SpringBootServletInitializer{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping(value="/hello")
	public String hello() {
		return "hello spring security";
	}
}

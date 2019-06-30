package com.imooc.entity;

import com.imooc.validation.Inser;
import com.imooc.validation.Update;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	@NotBlank(groups = {Inser.class} ,message = "用户名不能为空")
	private String userName;

	@NotBlank(groups = {Update.class},message = "年龄不能为空")
	private String age;
	
	private String xxx;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
}

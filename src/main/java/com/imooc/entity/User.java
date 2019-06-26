package com.imooc.entity;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	@NotBlank
	private String userName;
	
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

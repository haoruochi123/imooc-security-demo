package com.imooc.exception;

public class ControllerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public ControllerException(String name ,String msg) {
		super(msg);
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

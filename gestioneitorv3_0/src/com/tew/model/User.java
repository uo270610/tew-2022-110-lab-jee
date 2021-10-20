package com.tew.model;

public class User {

	private static final long serialVersionUID = 222222L;
	private String login;
	private String name;
	
	public User (String log, String nam) {
		this.login = log;
		this.name = nam;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}

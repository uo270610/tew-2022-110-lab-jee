package com.tew.business;

import com.tew.model.User;

public class SimpleLoginService implements LoginService {

	public User verify(String login, String password) {
		if (!validLogin(login, password))
			return null;
		return new User(login, "Sr Antúnez");
	}

	private boolean validLogin(String login, String password) {
		return "admin".equals(login) && "password".equals(password);
	}

}

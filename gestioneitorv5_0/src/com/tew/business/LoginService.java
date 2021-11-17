package com.tew.business;

import com.tew.model.User;

public interface LoginService {
	User verify(String name, String password);

}

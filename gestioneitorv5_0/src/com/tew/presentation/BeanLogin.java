package com.tew.presentation;

import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import com.tew.business.LoginService;
import com.tew.infrastructure.Factories;
import com.tew.model.User;

@ManagedBean(name = "login")
@SessionScoped
public class BeanLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password = "";

	public String verify() {
		FacesContext jsfCtx = FacesContext.getCurrentInstance();
		ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msgs");
		FacesMessage msg = null;
		LoginService login = Factories.services.createLoginService();

		User user = login.verify(name, password);
		if (user != null) {
			putUserInSession(user);
			return "success";
		}

		msg = new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("login_form_result_error"), null);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return "login";
	}

	private void putUserInSession(User user) {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();

		session.put("LOGGEDIN_USER", user);
	}
}

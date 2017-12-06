package com.beatrice.birdList.view.form;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.util.UserManager;


@RequestScoped
@Named
public class SignInHandler {
	private String username;
	private String password;
	
	@Inject
	private UserManager userManager;
	
	public String submit() {
		System.out.println("in submit,signInHandler username: " + username + " Password: " + password) ;
		return userManager.signIn(username, password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}


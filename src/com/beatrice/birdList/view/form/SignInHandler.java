package com.beatrice.birdList.view.form;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.manager.UserManager;

/**
 * Request scoped managed bean
 * Handles data from index/login page
 * Code partly written in class, Jensen education
 * @author Beatrice
 * @since 1.0
 *
 */
@RequestScoped
@Named
public class SignInHandler {
	private String username;
	private String password;
	
	@Inject
	private UserManager userManager;
	
	/**
	 * Sends input data to userManager to be validated
	 * @return address redirect
	 */
	public String submit() {
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


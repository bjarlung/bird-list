package com.beatrice.birdList.view.form;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.manager.UserManager;

/**
 * Request scoped managed bean
 * Handles data from register form
 * @author Beatrice
 * @since 1.0
 *
 */
@RequestScoped
@Named
public class SignUpHandler {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	@Inject
	private UserManager userManager;
	
	/**
	 * Creates new user and sends to userManager to be registered
	 * @return address redirect
	 */
	public String submit() {
		User user = new User();
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return userManager.signUp(user, password);
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}

package com.beatrice.birdList.model.manager;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.repository.user.UserRepoJDBC;
import com.beatrice.birdList.model.repository.user.UserRepository;

/**
 * Session scoped managed bean
 * Handles communication with userRepository regarding user's login, registration and log out
 * Holds the currently logged in user
 * Code partly written in class, Jensen education
 * @author Beatrice
 * @since 1.0
 *
 */
@SessionScoped
@Named
public class UserManager implements Serializable {
	
	/**
	 * serial version number for serialization
	 */
	private static final long serialVersionUID = -1239081068667660593L;

	private User currentUser;
	private UserRepository userRepo = new UserRepoJDBC();
	
	/**
	 * Gets the session and destroys it
	 * @return String, log in page
	 */
	public String signOut() {
		currentUser = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";		
	}
	
	/**
	 * Gets a user from repository according to log in data.
	 * Sets currentUser if the credentials were valid
	 * @param username
	 * @param password
	 * @return profile page if the log in was successful, or sets an error message
	 */
	public String signIn(String username, String password) {
		System.out.println("Signing in, userManager..");
		currentUser = userRepo.getUser(username, password);
		System.out.println("Signing in userManager, user: " + currentUser);
		if(currentUser != null) {
			return "profile";
		} else {
			FacesMessage message = new FacesMessage("Invalid credentials");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			return "index";
		}		
	}

	/**
	 * Registers new user in repository and sets currentUser
	 * @param user User object with user data
	 * @param password String
	 * @return profile page if the log in was successful, or sets an error message
	 */
	public String signUp(User user, String password) {
		currentUser = userRepo.addUser(user, password);	
		if(currentUser != null) {
			return "profile";
		} else {
			FacesMessage message = new FacesMessage("Invalid credentials");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			return "register";
		}
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
}

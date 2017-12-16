package com.beatrice.birdList.model.manager;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.repository.user.UserRepoJDBC;
import com.beatrice.birdList.model.repository.user.UserRepository;


@SessionScoped
@Named
public class UserManager implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1239081068667660593L;

	private User currentUser;
	
	private UserRepository userRepo = new UserRepoJDBC();
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	//hämtar sessionen och förstör den
	public String signOut() {
		currentUser = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		//när en session förstörs gör den det efter att användaren fått respons
		//med ?faces-redirect=true tvingar vi användaren att göra ett nytt anrop
		return "index?faces-redirect=true";		
	}
	
	public String signIn(String username, String password) {
		System.out.println("Signing in userManager..");
		currentUser = userRepo.getUser(username, password);
		System.out.println("Signing in userManager, user: " + currentUser);
		if(currentUser != null) {
			return "profile";
		} else {
			FacesMessage message = new FacesMessage("Invalid credentials");
			FacesContext context = FacesContext.getCurrentInstance();
			//null för då skickas den globalt
			context.addMessage(null, message);
			return "index";
		}	
		
	}

	public String signUp(User user, String password) {
		currentUser = userRepo.addUser(user, password);	
		if(currentUser != null) {
			return "profile";
		} else {
			FacesMessage message = new FacesMessage("Invalid credentials");
			FacesContext context = FacesContext.getCurrentInstance();
			//null för då skickas den globalt
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
	
}

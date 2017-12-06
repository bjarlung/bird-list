package com.beatrice.birdList.model.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.User;

@SessionScoped
@ManagedBean
public class UserManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static User currentUser;
	
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
		System.out.println("in signIn in userManager");
		currentUser = new User();
		System.out.println(currentUser.toString());
		currentUser.setUsername(username);
		
		return "WEB-INF/profile";
		//TODO
//		if(username.equals("abc") && password.equals("123")) {
//			currentUser = new User();
//			currentUser.setUsername(username);
//			System.out.println("in if in signIn");
//			return "profile?faces-redirect=true";
//		} else {
//			FacesMessage message = new FacesMessage("Invalid credentials");
//			FacesContext context = FacesContext.getCurrentInstance();
//			//null för då skickas den globalt
//			context.addMessage(null, message);
//			return "index";
//		}
		
	}

	public User signUp(User user) {
		
		
		return user;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		UserManager.currentUser = currentUser;
	}
	
	
}

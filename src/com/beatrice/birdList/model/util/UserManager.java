package com.beatrice.birdList.model.util;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.BirdList;
import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.database.birdList.WatchersRepoMongo;
import com.beatrice.birdList.model.database.birdList.WatchersRepository;
import com.beatrice.birdList.model.database.user.UserRepoJDBC;
import com.beatrice.birdList.model.database.user.UserRepository;

@SessionScoped
@Named
public class UserManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static User currentUser;
	
	private UserRepository userRepo = new UserRepoJDBC();
	private WatchersRepository birdRepo = new WatchersRepoMongo();
	
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
		currentUser = userRepo.getUser(username, password);
		if(currentUser != null) {
			return "WEB-INF/profile";
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
			return "WEB-INF/profile";
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
		UserManager.currentUser = currentUser;
	}
	
}

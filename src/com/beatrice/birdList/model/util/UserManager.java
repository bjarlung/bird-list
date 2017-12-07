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
@ManagedBean
public class UserManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static User currentUser;
	
	private UserRepository userRepo = new UserRepoJDBC();
	private WatchersRepository birdRepo = new WatchersRepoMongo();
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	//h�mtar sessionen och f�rst�r den
	public String signOut() {
		currentUser = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		//n�r en session f�rst�rs g�r den det efter att anv�ndaren f�tt respons
		//med ?faces-redirect=true tvingar vi anv�ndaren att g�ra ett nytt anrop
		return "index?faces-redirect=true";		
	}
	
	public String signIn(String username, String password) {
		currentUser = userRepo.getUser(username, password);
		if(currentUser != null) {
			return "WEB-INF/profile";
		} else {
			FacesMessage message = new FacesMessage("Invalid credentials");
			FacesContext context = FacesContext.getCurrentInstance();
			//null f�r d� skickas den globalt
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
			//null f�r d� skickas den globalt
			context.addMessage(null, message);
			return "register";
		}
	}
	
	public void updateUsersBirdLists() {
//		BirdList birdList = new BirdList();
//		System.out.println("user id in updateBirdLists: " + currentUser.getUserId());
//		birdList.setOwnerId(currentUser.getUserId());
//		birdList.setBirdListName("Jans livslista");
//		birdRepo.addBirdList(birdList);
		
		List<BirdList> birdListCollection = birdRepo.getBirdListsByUser(currentUser.getUserId());
		System.out.println("after get collection: " + birdListCollection);
		currentUser.setBirdListCollection(birdListCollection);
		System.out.println("after get birdlist, user manager: " + currentUser.getBirdListCollection());
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		UserManager.currentUser = currentUser;
	}
	
}

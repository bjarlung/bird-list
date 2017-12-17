package com.beatrice.birdList.model.manager;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;
import com.beatrice.birdList.model.beans.BirdList;
import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.repository.birdList.BirdersRepoMongo;
import com.beatrice.birdList.model.repository.birdList.BirdersRepository;

/**
 * Session scoped managed bean
 * Handles communication with BirdersRepository 
 * regarding creation and update of user's birdLists
 * @author Beatrice
 * @since 1.0
 *
 */
@SessionScoped
@Named
public class BirdListManager implements Serializable {

	/**
	 * serial version number for serialization
	 */
	private static final long serialVersionUID = 1088747602831838125L;

	private BirdersRepository birdersRepo = new BirdersRepoMongo();

	@Inject
	private UserManager userManager;

	/**
	 * Loads the current user's birdLists from repository
	 */
	public void loadBirdLists() {	
		User currentUser = userManager.getCurrentUser();
		userManager.setCurrentUser(birdersRepo.sync(currentUser));
		System.out.println("Loading users bird lists in birdListManager: " + currentUser);
	}

	/**
	 * Adding a new user birdList to the repository
	 * @param listName
	 * @return String, profile page if the user is logged in
	 */
	public String addList(String listName) {
		User currentUser = userManager.getCurrentUser();
		if(currentUser != null) {
			BirdList birdList = new BirdList();
			birdList.setBirdListName(listName);
			currentUser.getBirdListCollection().add(birdList);
			birdersRepo.updateUserLists(currentUser);		
			return "profile?faces-redirect=true";
		} else {
			setNotLoggedIn();	
			return "index";
		}
	}

	/**
	 * Updating data of specific bird in user's birdList
	 * sending updated user to repository for update
	 * @param bird Bird object containing updated data
	 * @return String, profile page if the user is logged in
	 */
	public String updateBird(Bird bird) {
		User currentUser = userManager.getCurrentUser();
		if(currentUser != null) {
			System.out.println("updateBird, BirdListManager. Bird: " + bird);
			BirdList birdList = currentUser.getCurrentBirdList();
			birdList.updateBirdInList(bird);
			birdersRepo.updateUserLists(currentUser);		
			return "profile?faces-redirect=true";
		} else {
			setNotLoggedIn();	
			return "index";
		}
	}

	/**
	 * Sets error message to context
	 */
	private void setNotLoggedIn() {
		FacesMessage message = new FacesMessage("Not logged in");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);	
	}

	/**
	 * Adding new bird to user's birdList
	 * sending updated user to repository for update
	 * @param bird
	 * @return String, profile page if the user is logged in
	 */
	public String addBird(Bird bird) {
		User currentUser = userManager.getCurrentUser();
		if(currentUser != null) {
			System.out.println("BirdListManager adding bird: " + bird.toString());
			BirdList birdList = currentUser.getCurrentBirdList();
			if(birdList != null) {
				birdList.addBirdToList(bird);
				birdersRepo.updateUserLists(currentUser);
			} else {
				System.out.println("in adding Bird, BirdListManager, no list found");
			}
			return "profile?faces-redirect=true";
		} else {
			setNotLoggedIn();	
			return "index";
		}
	}

}

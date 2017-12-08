package com.beatrice.birdList.model.util;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;
import com.beatrice.birdList.model.beans.BirdList;
import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.database.birdList.WatchersRepoMongo;
import com.beatrice.birdList.model.database.birdList.WatchersRepository;
import com.beatrice.birdList.model.util.UserManager;

@RequestScoped
@Named
public class BirdListManager {

	private WatchersRepository birdRepo = new WatchersRepoMongo();

	@Inject
	private UserManager userManager;

	public void loadBirdLists() {
		User currentUser = userManager.getCurrentUser();
		System.out.println("Loading users bird lists in profileHandler...");
		List<BirdList> birdListCollection = birdRepo.getBirdListsByUser(currentUser.getUserId());
		System.out.println("after get collection: " + birdListCollection);
		currentUser.setBirdListCollection(birdListCollection);
		System.out.println("after get birdlist, user manager: " + currentUser.getBirdListCollection());
	}

	public List<Bird> getListOfBirds() {
		//returning last added birdList of currentUser
		List<BirdList> birdListCollection = userManager.getCurrentUser().getBirdListCollection();
		return birdListCollection.get(birdListCollection.size()-1).getListOfBirds();
	}

	public String addList(String listName) {
		User currentUser = userManager.getCurrentUser();
		if(currentUser != null) {
			BirdList birdList = new BirdList();
			System.out.println("user id in updateBirdLists: " + currentUser.getUserId());
			birdList.setOwnerId(currentUser.getUserId());
			birdList.setBirdListName(listName);
			BirdList addedList = birdRepo.addBirdList(birdList);
			currentUser.getBirdListCollection().add(addedList);
			return "WEB-INF/profile";
		} else {
			FacesMessage message = new FacesMessage("Not logged in");
			FacesContext context = FacesContext.getCurrentInstance();
			//null för då skickas den globalt
			context.addMessage(null, message);
			return "register";
		}
	}

}

package com.beatrice.birdList.model.manager;


import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;
import com.beatrice.birdList.model.beans.BirdList;
import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.repository.birdList.WatchersRepoMongo;
import com.beatrice.birdList.model.repository.birdList.WatchersRepository;
import com.beatrice.birdList.model.util.BirdListUtil;

@SessionScoped
@Named
public class BirdListManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1088747602831838125L;

	private WatchersRepository birdRepo = new WatchersRepoMongo();

	@Inject
	private UserManager userManager;

	public void loadBirdLists() {	
		User currentUser = userManager.getCurrentUser();
		System.out.println("Loading users bird lists in profileHandler for user: " + currentUser);
		userManager.setCurrentUser(birdRepo.sync(currentUser));
		System.out.println("Loading users bird lists in profileHandler for sync: " + currentUser);

		//List<BirdList> birdListCollection = birdRepo.getBirdListsByUser(currentUser.getUserId());
		//System.out.println("after get collection: " + birdListCollection);
		//currentUser.setBirdListCollection(birdListCollection);
		//System.out.println("after get birdlist, birdListManager: " + currentUser.getBirdListCollection());
	}

	public String loadBird(String birdName) {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = context.getRequestMap();
		Bird bird = userManager.getCurrentUser().getCurrentBirdList().getBirdByName(birdName);
		requestMap.put("bird", bird);
		return "edit_bird_form";
	}

	public String addList(String listName) {
		User currentUser = userManager.getCurrentUser();
		if(currentUser != null) {
			BirdList birdList = new BirdList();
			System.out.println("user id in add list: " + currentUser.getUsername());
			birdList.setBirdListName(listName);
			//currentUser.setBirdList(birdList);
			currentUser.getBirdListCollection().add(birdList);
			birdRepo.updateUserLists(currentUser);		
			return "WEB-INF/profile";
		} else {
			setNotLoggedIn();	
			return "register";
		}
	}

	public String updateBird(Bird bird) {
		User currentUser = userManager.getCurrentUser();
		if(currentUser != null) {

			//			System.out.println("updating bird in BirdListManager");
			//			List<BirdList> birdListCollection = currentUser.getBirdListCollection();
			//			if(birdListCollection.size() > 0) {
			//				BirdList birdList = birdListCollection.get(birdListCollection.size()-1); //TODO
			//				birdList.addBirdToList(bird);
			//				birdRepo.updateUserLists(currentUser);
			//			} else {
			//				System.out.println("in update Bird, BirdListManager, no list found");
			//			}
			birdRepo.updateUserLists(currentUser);		
			return "WEB-INF/profile";
		} else {
			setNotLoggedIn();	
			return "register";
		}
	}

	private void setNotLoggedIn() {
		FacesMessage message = new FacesMessage("Not logged in");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);	
	}

	public String addBird(Bird bird) {
		User currentUser = userManager.getCurrentUser();
		if(currentUser != null) {
			System.out.println("BirdListManager adding bird: " + bird.toString());

			BirdList birdList = currentUser.getCurrentBirdList();
			if(birdList != null) {
				birdList.addBirdToList(bird);
				birdRepo.updateUserLists(currentUser);
			} else {
				System.out.println("in adding Bird, BirdListManager, no list found");
			}

			return "WEB-INF/profile";
		} else {
			setNotLoggedIn();	
			return "register";
		}
	}

}

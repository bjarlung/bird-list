package com.beatrice.birdList.view.form;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;
import com.beatrice.birdList.model.beans.BirdList;
import com.beatrice.birdList.model.util.UserManager;

@RequestScoped
@Named
public class ProfileHandler {
	
	
	@Inject
	private UserManager userManager;

	public void loadBirdLists() {
		System.out.println("Loading users bird lists in profileHandler...");
		userManager.updateUsersBirdLists();	
	}
	
	public List<Bird> getListOfBirds() {
		return userManager.getCurrentUser().getBirdListCollection().get(0).getListOfBirds();
	}
}

package com.beatrice.birdList.view.form;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;

import com.beatrice.birdList.model.manager.UserManager;


@RequestScoped
@Named
public class BirdTableHandler {

	private Bird selectedBird;

	@Inject
	private UserManager userManager;

	public List<Bird> getListOfBirds() {
		System.out.println("Getting listOFBirds in birdTableHandler");
		return userManager.getCurrentUser().getCurrentBirdList().getListOfBirds();	
	}
	
	public Bird getSelectedBird() {
		return selectedBird;
	}

	public void setSelectedBird(Bird selectedBird) {
		System.out.println("Setting selected to " + selectedBird.getName());
		this.selectedBird = selectedBird;
	}

}

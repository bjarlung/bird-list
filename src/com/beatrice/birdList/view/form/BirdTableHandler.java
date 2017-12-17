package com.beatrice.birdList.view.form;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;

import com.beatrice.birdList.model.manager.UserManager;

/**
 * Request scoped managed bean
 * Responsible for updating birdList in view
 * Additional functions to be implemented
 * @author Beatrice
 * @since 1.0
 *
 */
@RequestScoped
@Named
public class BirdTableHandler {

	private Bird selectedBird;

	@Inject
	private UserManager userManager;

	/**
	 * Gets users list of birds
	 * @return
	 */
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

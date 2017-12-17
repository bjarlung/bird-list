package com.beatrice.birdList.view.form;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;
import com.beatrice.birdList.model.manager.BirdListManager;

/**
 * Session scoped managed bean
 * Handles data from edit_bird_form
 * @author Beatrice
 * @since 1.0
 *
 */
@SessionScoped
@Named
public class EditBirdHandler implements Serializable {
	
	/**
	 * serial version number for serialization
	 */
	private static final long serialVersionUID = 6859142270872371819L;
	
	@Inject
	private BirdListManager birdListManager;
	
	private Bird selectedBird;

	/**
	 * Sets selectedBird and returns edit form
	 * @param bird
	 * @return
	 */
	public String loadBird(Bird bird) {
		System.out.println("EditBirdHandler, loadBird. Bird retrieved:" + bird);
		selectedBird = bird;
		return "edit_bird_form";
	}
	
	/**
	 * Calls birdListManager to update bird
	 * @return
	 */
	public String updateBird() {
		return birdListManager.updateBird(selectedBird);
	}

	public Bird getSelectedBird() {
		return selectedBird;
	}

}

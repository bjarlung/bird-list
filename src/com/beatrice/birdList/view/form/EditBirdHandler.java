package com.beatrice.birdList.view.form;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;
import com.beatrice.birdList.model.manager.BirdListManager;

@SessionScoped
@Named
public class EditBirdHandler implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6859142270872371819L;
	
	@Inject
	private BirdListManager birdListManager;
	
	private Bird selectedBird;

	public String loadBird(Bird bird) {
		//System.out.println("Loading bird, birdListManager. " + birdName);
		System.out.println("EditBirdHandler, loadBird. Bird retrieved:" + bird);
		selectedBird = bird;
		//ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		//Map<String, Object> requestMap = context.getRequestMap();
		//Bird bird = userManager.getCurrentUser().getCurrentBirdList().getBirdByName(birdName);
		//requestMap.put("bird", bird);
		return "edit_bird_form";
	}
	
	public String updateBird() {
		return birdListManager.updateBird(selectedBird);
	}

	public Bird getSelectedBird() {
		return selectedBird;
	}
	
	
	

}

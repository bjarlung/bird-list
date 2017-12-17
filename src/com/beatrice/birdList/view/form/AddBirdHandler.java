package com.beatrice.birdList.view.form;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.beans.Bird;
import com.beatrice.birdList.model.manager.BirdListManager;
import com.beatrice.birdList.model.util.BirdListUtil;

/**
 * Request scoped managed bean
 * Handles data from add_bird_form
 * @author Beatrice
 * @since 1.0
 *
 */
@RequestScoped
@Named
public class AddBirdHandler {

	private String birdName;
	
	@Inject
	private BirdListManager birdListManager;

	public String getBirdName() {
		return birdName;
	}

	public void setBirdName(String birdName) {
		this.birdName = birdName;
	}
	
	/**
	 * Creates new bird with chosen name and adds to users birdList through birdListManager
	 * @return
	 */
	public String addBird() {
		Bird bird = new Bird();
		bird.setId(Integer.toString(BirdListUtil.getBirdIdIncrement()));
		bird.setName(birdName);
		return birdListManager.addBird(bird);
	}
}

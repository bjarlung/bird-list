package com.beatrice.birdList.view.form;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.manager.BirdListManager;

/**
 * Request scoped managed bean
 * Handles data from create_bird_list form 
 * @author Beatrice
 * @since 1.0
 *
 */
@RequestScoped
@Named
public class NewListHandler {
	
	private String listName;
	
	@Inject
	private BirdListManager birdListManager;
	
	/**
	 * Calls birdListManager to create a new list
	 * @return
	 */
	public String create() {
		return birdListManager.addList(listName);
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}
	

}

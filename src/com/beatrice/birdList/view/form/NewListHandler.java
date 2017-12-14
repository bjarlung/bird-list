package com.beatrice.birdList.view.form;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beatrice.birdList.model.manager.BirdListManager;

@RequestScoped
@Named
public class NewListHandler {
	
	private String listName;
	
	@Inject
	private BirdListManager birdListManager;
	
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

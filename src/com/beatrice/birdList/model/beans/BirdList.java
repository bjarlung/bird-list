package com.beatrice.birdList.model.beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.beatrice.birdList.model.util.BirdListUtil;

@XmlRootElement
public class BirdList {
	
	private List<Bird> listOfBirds;
	private String birdListId;
	private Date creationDate;
	private String birdListName;
	private int ownerId;
	private String timePeriod;
	private String place;
	
	public BirdList() {
		creationDate = new Date();
		initBirdList();
		birdListId = Integer.toString(BirdListUtil.getBirdListIdIncrement());
	}

	private void initBirdList() {
		listOfBirds = BirdListUtil.getStandardListSw();
	}

	public List<Bird> getListOfBirds() {
		return listOfBirds;
	}

	public void setListOfBirds(List<Bird> listOfBirds) {
		this.listOfBirds = listOfBirds;
		for (Bird bird : listOfBirds) {
			System.out.println(bird.getName());
		}	
	}

	public Date getCreationDate() {
		return creationDate;
	}

	@XmlAttribute(name="birdListId")
	public String getBirdListId() {
		return birdListId;
	}

	public String getBirdListName() {
		return birdListName;
	}

	public void setBirdListName(String birdListName) {
		this.birdListName = birdListName;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "BirdList [listOfBirds=" + listOfBirds + ", birdListId=" + birdListId + ", creationDate=" + creationDate
				+ ", birdListName=" + birdListName + ", ownerId=" + ownerId + ", timePeriod=" + timePeriod + ", place="
				+ place + "]";
	}
	
	
	

}

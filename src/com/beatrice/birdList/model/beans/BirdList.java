package com.beatrice.birdList.model.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.beatrice.birdList.model.util.BirdListUtil;

@SessionScoped
@XmlRootElement
public class BirdList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3941600695037857157L;
	private List<Bird> listOfBirds;
	private Date creationDate;
	private String birdListName;
	private String timePeriod;
	private String place;
	
	public BirdList() {
		System.out.println("Creating new birdList, constructor");
		creationDate = new Date();
		initBirdList();
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
			System.out.println("BirdList. setListOfBirds : " + bird.getName());
		}	
	}

	public Date getCreationDate() {
		return creationDate;
	}

	@XmlAttribute(name="birdListName")
	public String getBirdListName() {
		return birdListName;
	}

	public void setBirdListName(String birdListName) {
		this.birdListName = birdListName;
	}
	
	public void addBirdToList(Bird bird) {
		System.out.println("BirdList. Adding: " + bird.toString());
		listOfBirds.add(bird);
	}
	
	public Bird getBirdByName(String birdName) {
		for (Bird bird : listOfBirds) {
			String tempName = bird.getName();
			if(tempName.equals(birdName))
				return bird;
		}
		return null;
	}
	

	@Override
	public String toString() {
		return "BirdList [listOfBirds=" + listOfBirds + ", creationDate=" + creationDate
				+ ", birdListName=" + birdListName + ", timePeriod=" + timePeriod + ", place="
				+ place + "]";
	}
	
	
	

}

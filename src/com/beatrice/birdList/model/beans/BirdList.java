package com.beatrice.birdList.model.beans;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.beatrice.birdList.model.util.BirdListUtil;

/**
 * Represents a bird list,
 * containing a list of Bird-objects and variables as listName and creationDate
 * @author Beatrice
 * @since 1.0
 *
 */
@XmlRootElement
public class BirdList {	

	private List<Bird> listOfBirds;
	private Date creationDate;
	private String birdListName;
	
	/**
	 * Creating a birdList with default list of birds
	 * setting creationDate
	 */
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
	
	/**
	 * Searches listOfBirds for a bird with a specific name
	 * returns bird object if found
	 * @param birdName String
	 * @return 
	 */
	public Bird getBirdByName(String birdName) {
		for (Bird bird : listOfBirds) {
			String tempName = bird.getName();
			if(tempName.equals(birdName))
				return bird;
		}
		return null;
	}
	
	/**
	 * Finds bird in listOfBirds and updates variables according to param
	 * @param updatedBird Bird. Bird object with updated instance variables
	 */
	public void updateBirdInList(Bird updatedBird) {
		System.out.println("BirdList, updateBirdInList with: " + updatedBird);
		Bird toBeUpdated = getBirdByName(updatedBird.getName());
		toBeUpdated.setComment(updatedBird.getComment());
		toBeUpdated.setSpotted(updatedBird.isSpotted());
		toBeUpdated.setDate(new Date());
	}

	@Override
	public String toString() {
		return "BirdList [listOfBirds=" + listOfBirds + ", creationDate=" + creationDate + ", birdListName="
				+ birdListName + "]";
	}
	

	
	
	
	

}

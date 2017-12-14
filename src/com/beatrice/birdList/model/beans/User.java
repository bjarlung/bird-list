package com.beatrice.birdList.model.beans;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@SessionScoped
@XmlRootElement
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3104055580743760714L;
	
	private int userId;
	private String username;
	private String firstName;
	private String lastName;
	private List<BirdList> birdListCollection;
	
	public User() {
		System.out.println("Creating new user, user constructor");
		birdListCollection = new LinkedList<>();
	}
	
	public List<BirdList> getBirdListCollection() {
		return birdListCollection;
	}

	public void setBirdListCollection(List<BirdList> birdListCollection) {
		this.birdListCollection = birdListCollection;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BirdList getCurrentBirdList() {
		if(birdListCollection.size() > 0) {
			return birdListCollection.get(birdListCollection.size()-1);
		} else {
			System.out.println("User, getCurrentBirdList. No birdList found in users collection");
			return null;
		}
	}
	
	@XmlAttribute(name="userId")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birdListCollection=" + birdListCollection + "]";
	}


	
	
	
	
}


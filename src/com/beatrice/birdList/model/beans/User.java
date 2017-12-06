package com.beatrice.birdList.model.beans;

import java.util.ArrayList;
import java.util.List;

import com.beatrice.birdList.model.util.BirdListUtil;


public class User {
	
	private int userId;
	private String username;
	private String firstName;
	private String lastName;
	private List<BirdList> birdListCollection;
	private List<Bird> birdList;
	
	public User() {
		System.out.println("Creating new user, user constructor");
		birdListCollection = new ArrayList<>();
//		birdList = BirdListUtil.getStandardListSw();
//		for (Bird bird : birdList) {
//			System.out.println(bird.getName());
//		}
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

	public List<Bird> getBirdList() {
		return birdList;
	}

	public void setBirdList(List<Bird> birdList) {
		this.birdList = birdList;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", birdList="
				+ birdList + "]";
	}

	
	
	
	
}


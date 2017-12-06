package com.beatrice.birdList.model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import com.beatrice.birdList.model.util.BirdListUtil;

@SessionScoped
@ManagedBean
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String firstName;
	private String lastName;
	private List<Bird> birdList;
	
	public User() {
		System.out.println("Creating new user, user constructor");
		birdList = BirdListUtil.getStandardListSw();
		for (Bird bird : birdList) {
			System.out.println(bird.getName());
		}
		
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

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", birdList="
				+ birdList + "]";
	}

	
	
	
	
}


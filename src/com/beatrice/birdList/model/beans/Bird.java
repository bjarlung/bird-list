package com.beatrice.birdList.model.beans;

import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@SessionScoped
@XmlRootElement
public class Bird {
	private String name;
	private String birdId;	
	
	private boolean spotted;
	private Date date;
	private String comment;
	
	public Bird(String name, String birdId) {
		this.name = name;
		this.birdId = birdId;
		spotted = false;
		date = new Date();
	}
	
	public boolean isSpotted() {
		return spotted;
	}
	
	public void setSpotted(boolean spotted) {
		this.spotted = spotted;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name="birdId")
	public String getBirdId() {
		return birdId;
	}

	public void setId(String birdId) {
		this.birdId = birdId;
	}

	@Override
	public String toString() {
		return "Bird [name=" + name + ", birdId=" + birdId + ", spotted=" + spotted + ", date=" + date + ", comment="
				+ comment + "]";
	}
	
	

}

package com.beatrice.birdList.model.beans;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.beatrice.birdList.model.util.BirdListUtil;

@XmlRootElement
public class BirdList {
	
	private List<Bird> list;
	private String birdListId;
	private Date creationDate;
	private String birdListName;
	
	public BirdList() {
		creationDate = new Date(); //TODO
		initBirdList();
		birdListId = Integer.toString(BirdListUtil.getBirdListIdIncrement());
	}

	private void initBirdList() {
		list = BirdListUtil.getStandardListSw();
	}

	public List<Bird> getList() {
		return list;
	}

	public void setList(List<Bird> list) {
		this.list = list;
		for (Bird bird : list) {
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
	
	
	

}

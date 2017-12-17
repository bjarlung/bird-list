package com.beatrice.birdList.model.util;

import java.util.LinkedList;
import java.util.List;

import com.beatrice.birdList.model.beans.Bird;

/**
 * Handles import of standard list of birds
 * @author Beatrice
 * @since 1.0
 *
 */
public class BirdListUtil {
	
	private static int birdIdIncrement = 300;
	
	/**
	 * Temporary method implementation
	 * @return
	 */
	public static List<Bird> getStandardListSw() {
		List<Bird> swedenBirdList = new LinkedList<>();
		//TODO get from list
		Bird bird = new Bird();
		bird.setId("1");
		bird.setName("knölsvan");
		swedenBirdList.add(bird); 
	
		bird = new Bird();
		bird.setId("2");
		bird.setName("gråsparv");
		swedenBirdList.add(bird);
		
		bird = new Bird();
		bird.setId("3");
		bird.setName("rödhake");
		swedenBirdList.add(bird);
		
		bird = new Bird();
		bird.setId("4");
		bird.setName("havsörn");
		swedenBirdList.add(bird);
		
		return swedenBirdList;
		
	}
	
	/**
	 * Getter for additional birds' id numbers
	 * @return
	 */
	public static int getBirdIdIncrement() {
		return birdIdIncrement++;
	}
	

}

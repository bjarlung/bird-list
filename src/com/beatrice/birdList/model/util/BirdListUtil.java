package com.beatrice.birdList.model.util;

import java.util.LinkedList;
import java.util.List;

import com.beatrice.birdList.model.beans.Bird;

public class BirdListUtil {
	
	private static int birdIdIncrement = 300;
	
	public static List<Bird> getStandardListSw() {
		List<Bird> swedenBirdList = new LinkedList<>();
		//TODO get from list
		Bird bird = new Bird();
		bird.setId("1");
		bird.setName("swan");
		swedenBirdList.add(bird); 
	
		bird = new Bird();
		bird.setId("2");
		bird.setName("sparrow");
		swedenBirdList.add(bird);
		
		bird = new Bird();
		bird.setId("3");
		bird.setName("robin");
		swedenBirdList.add(bird);
		
		bird = new Bird();
		bird.setId("4");
		bird.setName("eagle");
		swedenBirdList.add(bird);
		
		return swedenBirdList;
		
	}
	
	public static int getBirdIdIncrement() {
		return birdIdIncrement++;
	}
	

}

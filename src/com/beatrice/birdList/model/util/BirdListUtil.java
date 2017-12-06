package com.beatrice.birdList.model.util;

import java.util.LinkedList;
import java.util.List;

import com.beatrice.birdList.model.beans.Bird;

public class BirdListUtil {
	
	private static int incrementBirdListId;
	
	public static List<Bird> getStandardListSw() {
		List<Bird> swedenBirdList = new LinkedList<>();
		swedenBirdList.add(new Bird("Swan", "1")); //TODO get from list
		swedenBirdList.add(new Bird("sparrow", "2"));
		swedenBirdList.add(new Bird("robin", "3"));
		swedenBirdList.add(new Bird("hawk", "4"));
		swedenBirdList.add(new Bird("eagle", "5"));
		return swedenBirdList;
		
	}
	
	public static int getBirdListIdIncrement() {
		return ++incrementBirdListId;
	}

}

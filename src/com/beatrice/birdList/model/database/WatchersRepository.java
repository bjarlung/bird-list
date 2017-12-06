package com.beatrice.birdList.model.database;

import com.beatrice.birdList.model.beans.BirdList;

public interface WatchersRepository {
	BirdList findBirdList(String key);
	BirdList createBirdList(String countryCode);
	BirdList editBirdList(BirdList birdList);
	boolean deleteBirdList(BirdList birdList);
	
	
}

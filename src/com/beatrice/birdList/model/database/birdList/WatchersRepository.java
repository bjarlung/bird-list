package com.beatrice.birdList.model.database.birdList;

import java.util.List;

import com.beatrice.birdList.model.beans.BirdList;

public interface WatchersRepository {
	List<BirdList> getBirdListsByUser(int userId);
 	BirdList findBirdList(String key);
	BirdList addBirdList(BirdList birdList);
	BirdList editBirdList(BirdList birdList);
	boolean deleteBirdList(BirdList birdList);	
}

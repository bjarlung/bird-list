package com.beatrice.birdList.model.repository.birdList;

import com.beatrice.birdList.model.beans.User;

public interface WatchersRepository {
	User sync(User user);
	//User addUser(User user);
	User updateUserLists(User user);
	//void addNewUser(User user);
	//public Document getUser(User user);
	//boolean deleteBirdList(BirdList birdList);
	//BirdList addBirdToList(BirdList birdList, Bird bird);
}

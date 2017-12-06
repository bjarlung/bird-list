package com.beatrice.birdList.model.database;

import com.beatrice.birdList.model.beans.User;

public interface UserRepository {
	User getUser(String username, String password);
	User addUser(User user);
	boolean deleteUser(User user);
	User updateUser(User user);
}

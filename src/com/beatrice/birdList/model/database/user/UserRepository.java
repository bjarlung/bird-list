package com.beatrice.birdList.model.database.user;

import com.beatrice.birdList.model.beans.User;

public interface UserRepository {
	User getUser(String username, String password);
	User addUser(User user, String password);
	boolean deleteUser(User user);
	User updateUser(User user);
}

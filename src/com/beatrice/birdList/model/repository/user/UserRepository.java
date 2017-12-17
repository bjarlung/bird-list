package com.beatrice.birdList.model.repository.user;

import com.beatrice.birdList.model.beans.User;

/**
 * Interface defining communication to user database
 * @author Beatrice
 * @since 1.0
 *
 */
public interface UserRepository {
	User getUser(String username, String password);
	User addUser(User user, String password);
	boolean deleteUser(User user);
	User updateUser(User user);
}

package com.beatrice.birdList.model.repository.birdList;

import com.beatrice.birdList.model.beans.User;

/**
 * Interface defining communication to database holding users' birdLists
 * @author Beatrice
 * @since 1.0
 *
 */
public interface WatchersRepository {
	User sync(User user);
	User updateUserLists(User user);
}

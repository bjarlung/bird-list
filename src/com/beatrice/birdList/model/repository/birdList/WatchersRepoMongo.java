package com.beatrice.birdList.model.repository.birdList;


import org.bson.Document;

import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.database.MongoDB;

import com.google.gson.Gson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

/**
 * Implements WatchersRepository interface.
 * Handles communication with MongoDB database
 * @author Beatrice
 * @since 1.0
 *
 */
public class WatchersRepoMongo implements WatchersRepository {
	
	private Gson gson = new Gson();
	MongoCollection<Document> collection = MongoDB.getInstance().getDatabase();	

	/**
	 * Makes sure the program and database data are synced
	 * Retrieves user from database to update current user in program
	 * Updates database if the user is not found
	 */
	@Override
	public User sync(User user) {
		System.out.println("In sync WatchersRepo, user: " + user.toString());
		Document result = getUser(user);	
		if(result == null) {
			addNewUser(user);
			return user;
		} else {
			String jsonObj = result.toJson();
			System.out.println("JsonObj from sync MongoRepo" +jsonObj);
			User updatedUser = gson.fromJson(jsonObj, User.class);
			System.out.println("synced user, watchersRepo: " + updatedUser.toString());
			return updatedUser;
		}	
	}
	
	/**
	 * Updates user's bird list collection in database
	 */
	@Override
	public User updateUserLists(User user) {
		System.out.println("Updating users list, watchersRepo. List: " + gson.toJson(user));
		Document document = Document.parse(gson.toJson(user));
		collection.updateOne(Filters.eq("username", user.getUsername()), new Document("$set", document));
		return user;
	}
	
	/**
	 * Adds new user to database
	 * @param user
	 */
	private void addNewUser(User user) {
		System.out.println("MongoRepo. Adding new user to DB: " + user.getUsername());
		Document document = Document.parse(gson.toJson(user));
		collection.insertOne(document);
	}
	
	/**
	 * Gets specified user from database
	 * @param user
	 * @return Document, user in document object
	 */
	private Document getUser(User user) {
		System.out.println("getting user from Mongo in WatchersRepoMongo...");
		return collection.find(Filters.eq("username", user.getUsername())).first();
	}

}


//
//	@Override
//	public boolean deleteBirdList(BirdList birdList) {
//		collection.deleteOne(Filters.eq("birdListName", birdList.getBirdListName()));	
//		return true;
//	}
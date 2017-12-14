package com.beatrice.birdList.model.repository.birdList;


import org.bson.Document;

import com.beatrice.birdList.model.beans.BirdList;
import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.database.MongoDB;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class WatchersRepoMongo implements WatchersRepository{
	private Gson gson = new Gson();
	MongoCollection<Document> collection = MongoDB.getInstance().getDatabase();	

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
			Document birdListCollection = collection.find(Filters.eq("birdListName", "january")).first();
			System.out.println("BirdListCollection from Mongo: " + birdListCollection);
			return updatedUser;
		}	
	}
	
	@Override
	public User updateUserLists(User user) {
		System.out.println("Updating users list, watchersRepo. List: " + gson.toJson(user));
		Document document = Document.parse(gson.toJson(user));
		//collection.insertOne(document);
		collection.updateOne(Filters.eq("username", user.getUsername()), new Document("$set", document));
		return user;
	}
	
	private void addNewUser(User user) {
		System.out.println("MongoRepo. Adding new user to DB: " + user.getUsername());
		Document document = Document.parse(gson.toJson(user));
		collection.insertOne(document);
	}
	

	private Document getUser(User user) {
		System.out.println("getting user from Mongo in WatchersRepoMongo...");
		return collection.find(Filters.eq("username", user.getUsername())).first();
	}



//	@Override
//	public User addUser(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	//	@Override
	//	public BirdList addBirdList(BirdList birdList) {
	//		if(birdList.getOwnerId() == 0) {
	//			System.out.println("no owner, WatchersRepo addBirdList");
	//			return null;
	//		} else {
	//			System.out.println("WatchersRepo, addBirdList. Connection to Mongo");	 
	//			System.out.println("adding birdList named: " + birdList.getBirdListName());	
	//			Document document = Document.parse(gson.toJson(birdList));
	//			collection.insertOne(document);
	////			String birdListId = document.get("_id" ).toString();
	////			System.out.println("MongoRepo. AddBirdList id set to: " + birdListId);
	////			birdList.setBirdListId(birdListId);
	//			return birdList;
	//		}
	//	}

	//	@Override
	//	public BirdList updateBirdList(BirdList birdList) { 
	//		System.out.println("WatchersRepo updating birdList in DB, id" + birdList.getBirdListId());
	//		Document document = Document.parse(gson.toJson(birdList));
	//		collection.updateOne(Filters.eq("birdListName", birdList.getBirdListName()), new Document("$set", document));
	//		return birdList;
	//	}
	//
	//	@Override
	//	public boolean deleteBirdList(BirdList birdList) {
	//		collection.deleteOne(Filters.eq("birdListName", birdList.getBirdListName()));	
	//		return true;
	//	}

	
//	List<BirdList> birdListCollection = new ArrayList<>();
	//		while(result.hasNext()) {
	//			String jsonObj = result.next().toJson();
	//			BirdList birdList = gson.fromJson(jsonObj, BirdList.class);
	//			System.out.println("getBirdListByUser in mongo repo: " + birdList);
	//			birdListCollection.add(birdList);
	//		}



}

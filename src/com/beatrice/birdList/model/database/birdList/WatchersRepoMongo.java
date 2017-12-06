package com.beatrice.birdList.model.database.birdList;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.beatrice.birdList.model.beans.BirdList;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class WatchersRepoMongo implements WatchersRepository {
	private Gson gson = new Gson();

	@Override
	public List<BirdList> getBirdListsByUser(int userId) {
		MongoCollection<Document> collection = MongoDB.getInstance().getDatabase();	
		MongoCursor<Document> result = collection.find(Filters.eq("userId", userId)).iterator();
		List<BirdList> birdListCollection = new ArrayList<>();
		while(result.hasNext()) {
			String jsonObj = result.next().toJson();
			BirdList birdList = gson.fromJson(jsonObj, BirdList.class);
			birdListCollection.add(birdList);
		}
		//MongoDB.getInstance().closeConnection();
		return birdListCollection;
	}

	@Override
	public BirdList addBirdList(BirdList birdList) {
		MongoCollection<Document> collection = MongoDB.getInstance().getDatabase();	 
		System.out.println("adding birdList " + birdList.getBirdListName());	
		Document document = Document.parse(gson.toJson(birdList));
		collection.insertOne(document);
		return birdList;
	}

	@Override
	public BirdList editBirdList(BirdList birdList) {
		MongoCollection<Document> collection = MongoDB.getInstance().getDatabase();	 
		Document document = Document.parse(gson.toJson(birdList));
		collection.updateOne(Filters.eq("birdListId", birdList.getBirdListId()), new Document("$set", document));
		return birdList;
	}

	@Override
	public boolean deleteBirdList(BirdList birdList) {
		MongoCollection<Document> collection = MongoDB.getInstance().getDatabase();	
		collection.deleteOne(Filters.eq("birdListId", birdList.getBirdListId()));	
		return true;
	}

	@Override
	public BirdList findBirdList(String key) {
		return null;
	}
	

}

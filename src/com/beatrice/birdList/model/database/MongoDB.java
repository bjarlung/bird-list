package com.beatrice.birdList.model.database;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
	private static MongoDB instance;
	private MongoCollection<Document> collection;
	private MongoClient mongo;
	
	private MongoDB() {
		mongo = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase = mongo.getDatabase("birdListDB");
		collection = mongoDatabase.getCollection("birdList");
	}

	public static MongoDB getInstance() {
		if(instance == null) {
			instance = new MongoDB();
		}
		return instance;
	}
	
	public MongoCollection<Document> getDatabase() {
		return collection;
	}
	
	public void closeConnection() {
		mongo.close();
		instance = null;
	}
	
}

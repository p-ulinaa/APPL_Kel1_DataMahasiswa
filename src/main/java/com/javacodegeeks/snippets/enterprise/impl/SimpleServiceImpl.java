package com.javacodegeeks.snippets.enterprise.impl;

import com.javacodegeeks.snippets.enterprise.SimpleService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleServiceImpl implements SimpleService {

	public SimpleServiceImpl(){

	 Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://uli:231407Jerapah99.@firstcluster-6mqrj.mongodb.net/test")) {

            MongoDatabase dataMahasiswaDB = mongoClient.getDatabase("datamahasiswa");
            MongoCollection<Document> mahasiswaCollection = dataMahasiswaDB.getCollection("mahasiswa");

        }
	}

	public void insertOneDocument() {
		
    };
    

}
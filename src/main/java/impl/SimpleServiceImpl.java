package impl;

import data.mahasiswa.SimpleService;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.quickstart.models.Mahasiswa;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class SimpleServiceImpl implements SimpleService {
 MongoDatabase database;
 MongoCollection<Mahasiswa> mahasiswaCollection;
 public SimpleServiceImpl() {
 MongoCredential credential; 
 credential = MongoCredential.createCredential("sampleUser", "mahasiswadb", "password".toCharArray()); 
 System.out.println("--Connected to the database successfully--");  

 CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
         fromProviders(PojoCodecProvider.builder().automatic(true).build()));  
 MongoClient mongo = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
 
 // Accessing the database 
 database = mongo.getDatabase("mahasiswadb"); 
 mahasiswaCollection = database.getCollection("mahasiswaCollection", Mahasiswa.class);
 database = database.withCodecRegistry(pojoCodecRegistry);
 }

 public boolean createMahasiswa(String nim,String nama,int semester, String jurusan, String alamat) {
  String idMahasiswa = new ObjectId().toString();
  try {
   Mahasiswa mahasiswa = new Mahasiswa(idMahasiswa, nim, nama, semester,jurusan, alamat);
   mahasiswaCollection.insertOne(mahasiswa);
   System.out.println("[Account Created]");
  } catch (Exception e) {
   e.printStackTrace();
   return false;
  } 
  
  return true;
 }
    


}
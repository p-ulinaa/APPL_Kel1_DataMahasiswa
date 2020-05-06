package impl;

import data.mahasiswa.SimpleService;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.quickstart.models.Mahasiswa;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
 	
 	@Override
 	public void createMahasiswa() {
		 	Mahasiswa mahasiswa = insertMahasiswa();
		 	mahasiswaCollection.insertOne(mahasiswa);
	
	}
 	
 	public Mahasiswa insertMahasiswa() {
 		Scanner sc = new Scanner(System.in);
 		String idMahasiswa = new ObjectId().toString();
 		String nim;
 		String nama; 
 		int semester;
 		String jurusan;
 		String alamat;
 		
 		System.out.print("nama     : ");
 		nama = sc.next();
 		System.out.print("nim      : ");
 		nim  = sc.next();
 		System.out.print("semester : ");
 		semester = sc.nextInt();
 		System.out.print("jurusan  : ");
 		jurusan = sc.next();
 		System.out.print("alamat   : ");
 		alamat = sc.next();
 		
 		Mahasiswa mahasiswa = new Mahasiswa(idMahasiswa, nim, nama, semester, jurusan, alamat);
 		return mahasiswa;
 		
 	}
 	public void getMahasiswa() {		
	 	int i = 1;
		FindIterable<Mahasiswa> mahasiswaIterable = mahasiswaCollection.find();		
		for (Mahasiswa mahasiswa : mahasiswaIterable) {
			System.out.println(i + " nama : "+ mahasiswa.getNama());
			System.out.println("  nim : "+ mahasiswa.getNim());
			System.out.println("  semester : "+ mahasiswa.getSemester());
			System.out.println("  nim : "+ mahasiswa.getNim());
			System.out.println("  jurusan : "+ mahasiswa.getJurusan());
			System.out.println("  nim : "+ mahasiswa.getNim());
			System.out.println("  alamat : "+ mahasiswa.getAlamat()+"\n");
			i++;
		}		
 	}

	
 	
}
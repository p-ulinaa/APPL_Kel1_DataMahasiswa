package data.mahasiswa;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
	
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			SimpleService simpleService = (SimpleService) context.getBean("simpleServiceBean");
			
			System.out.println("---------------");
			try{
				boolean A = simpleService.createMahasiswa("18152401", "Alvira", 4, "Teknik Informatika", "Bandung");
			} catch(Exception e){
				//System.out.println("SimpleService checkName() : Exception thrown..");
			}
			System.out.println("---------------");
			context.close();
	}
	
	public static void A() {
		System.out.println("--------------------");
	}
}



package data.mahasiswa;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
			boolean NotExit = true;
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			SimpleService simpleService = (SimpleService) context.getBean("simpleServiceBean");
			try{

				while(NotExit) {
					System.out.println("-------------------------------------");
					switch(Menu()) {
						case 1:
							simpleService.createMahasiswa();
							break;
						case 2:
							simpleService.getMahasiswa();
							break;
						case 3:
							System.out.println("Thankyou");
							NotExit = false;
							break;
					}
				}

			} catch(Exception e){
				System.out.println("SimpleService checkName() : Exception thrown..");
			}
			System.out.println("-------------------------------------");
			context.close();
	}
	
	public static int Menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Menu :");
		System.out.println("1. Add Student Data");
		System.out.println("2. Display Student Data");
		System.out.println("3. Exit");
		System.out.print("\nYour choice =");
		int pilihan = scanner.nextInt();
		System.out.println("-------------------------------------");
		return pilihan;
	}
}
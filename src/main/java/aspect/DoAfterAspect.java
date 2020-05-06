package aspect;

	import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
	import org.aspectj.lang.annotation.Aspect;
import org.aspectj.weaver.ast.Call;
import org.aspectj.lang.annotation.After;

	@Aspect
	public class DoAfterAspect {
	 
		@After("execution(* data.mahasiswa.SimpleService.createMahasiswa(..))")
		public void doAfter(JoinPoint joinPoint) {
	 
			System.out.println("Task\t: " + joinPoint.getSignature().getName());
			System.out.println("Message\t: Data successfully added");
			
		}
	 
		@After("execution(* data.mahasiswa.App.A(..))")
		public void doAfter2(JoinPoint joinPoint) {
			
				//Scanner scanner = new Scanner(System.in);
				System.out.println("--------------------");
				System.out.println("Menu:");
				System.out.println("1. Add Data");
				System.out.println("2. ");
				//int pilihan = scanner.nextInt();
				System.out.println("--------------------");
			
		}
	}
	

package aspect;

	import java.util.Arrays;
import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.weaver.ast.Call;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;

	@Aspect
	public class createOperationAspect {
	
	@Around("execution(* data.mahasiswa.SimpleService.createMahasiswa(..))")
	public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("Task\t: " + joinPoint.getSignature().getName());

		System.out.println("Message\t: Creating Data ...");
		joinPoint.proceed(); // continue on the intercepted method
		
		System.out.println("Message\t: Data successfully added");
	}
}
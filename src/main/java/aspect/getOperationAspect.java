package aspect;

	import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
	 
	@Aspect
	public class getOperationAspect {
	 
		@Around("execution(* data.mahasiswa.SimpleService.createMahasiswa(..))")
		public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {

			System.out.println("Task\t: " + joinPoint.getSignature().getName());

			System.out.println("Message\t: Getting Data ...");
			joinPoint.proceed(); // continue on the intercepted method
			
			System.out.println("Message\t: Data Displayed");
		}
	 
	}

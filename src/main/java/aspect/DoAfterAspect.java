package aspect;

	import org.aspectj.lang.JoinPoint;
	import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.After;
	 
	@Aspect
	public class DoAfterAspect {
	 
		@After("execution(* data.mahasiswa.SimpleService.createMahasiswa(..))")
		public void doAfter(JoinPoint joinPoint) {
	 
			System.out.println("Task\t: " + joinPoint.getSignature().getName());
			System.out.println("Message\t: Data successfully added");
			
		}
	 
	}

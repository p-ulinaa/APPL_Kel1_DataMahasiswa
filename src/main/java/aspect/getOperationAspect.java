package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class getOperationAspect {

	@Before("execution(* data.mahasiswa.SimpleService.createData(..))")
	public void doBefore(JoinPoint joinPoint) {

		System.out.println("***AspectJ*** DoBefore() is running!! intercepted : "
						+ joinPoint.getSignature().getName());
	}

}

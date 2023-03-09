package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	@Before(value = "execution(public * aop.OrderService.*(..))")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("Before adivce for :" + jp.getSignature());
	}

	@AfterReturning(value = "execution(public * aop.OrderService.*(..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("After Returning adivce for :" + jp.getSignature());
	}

	@AfterThrowing(value = "execution(public * aop.OrderService.*(..))", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint jp, Exception ex) {
		System.out.println("After throwing advice : " + jp.getSignature());
		System.out.println(ex);
	}

	@Around(value = "execution(public * aop.OrderService.getStatus(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("About to call method.." + pjp.getSignature());
		Object retVal = pjp.proceed(pjp.getArgs()); // invoke actual method 
		System.out.println("Completed the meethod.." + pjp.getSignature());

		return retVal;

	}
}

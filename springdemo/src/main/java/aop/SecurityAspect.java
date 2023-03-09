package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component 
public class SecurityAspect {
	
	@Pointcut("execution(public * aop.OrderService.placeOrder(..))")
	public void placeOrder() {
		
	}
	@Pointcut("execution(public * aop.OrderService.cancelOrder(..))")
	public void cancelOrder() {
		
	}
	@Pointcut("execution(public * aop.CustomerService.*(..))")
	public void customerMethods() {
		
	}

	@Before("placeOrder() || cancelOrder() || customerMethods()")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("Check " + jp.getSignature());
	}
}

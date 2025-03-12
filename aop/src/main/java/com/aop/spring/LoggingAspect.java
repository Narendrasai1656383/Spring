package com.aop.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* com.aop.spring.ShoppingCart.checkout())")
	public void beforeLogger() {
		System.out.println("Before logger");
	}
	@After("execution(* *.*.*.*.checkout())")
	public void afterLogger() {
		System.out.println("After logger");
	}
}

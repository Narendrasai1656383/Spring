package com.aop.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticatecationAspect {
	@Pointcut("within(com.aop.spring.ShoppingCart)")
	public void authenticatingPointCut() {
		
	}
	@Pointcut("within(com.aop.spring.ShoppingCart)")
	public void authorizationPointCut() {
		
	}
	@Before("authenticatingPointCut() && authorizationPointCut()")
	public void authenticate() {
		System.out.println("authenticating the request");
	}
}

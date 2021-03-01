package com.au.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {

	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Logging Advice");

	}
	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("Second Advice");

	}
	@Pointcut("execution(public * get*(..))")
	public void allGetters() {
	}
	@Pointcut("execution(public * set*(..))")
	public void allSetters() { }
	@After("allSetters()")
	public void afterAdvice() {
		System.out.println("This is executed after the Setter method");
	}
	@AfterReturning(pointcut="execution(public * *(..))", returning = "Val")
	public void afterReturningAdvice(JoinPoint jp, Object Val) {
		System.out.println("After Returning");
		System.out.println("Returning:" + Val.toString() );
	}
	@AfterThrowing(pointcut = "execution( public * *(..))", throwing="error")
	public void afterThrowingAdivce() {
		System.out.println("Exception occured");
	}
	@Pointcut("execution (public * set*(..))")
	private void setterMethods() {}
	@Around("setterMethods()")
	public void aroundAdvice() {
		System.out.println("In Around Advice");
	}
}

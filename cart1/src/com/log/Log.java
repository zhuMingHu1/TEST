package com.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class Log {
	private Logger logger = Logger.getLogger(this.getClass());

	/*@Before("execution(* com.service.impl.CartServiceImpl.*(..))")
	public void Before(){
		System.out.println("������");
	}*/
	
	@Around("execution(* com.service.impl.CartServiceImpl.*(..))")
	public Object Around(ProceedingJoinPoint jp) throws Throwable{
		System.out.println(jp.getSignature()+"��ʼִ��");
		long start = System.currentTimeMillis();
		Object result = jp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺" + (end - start));
		return result;
	}
	
	@AfterThrowing("execution(* com.service.impl.CartServiceImpl.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		// ʹ��log4j��¼��־
		System.out.println("�����쳣");
		logger.error(joinPoint.toShortString() + "���������쳣:");
	}
}

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
		System.out.println("啊哈哈");
	}*/
	
	@Around("execution(* com.service.impl.CartServiceImpl.*(..))")
	public Object Around(ProceedingJoinPoint jp) throws Throwable{
		System.out.println(jp.getSignature()+"开始执行");
		long start = System.currentTimeMillis();
		Object result = jp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("方法运行时间：" + (end - start));
		return result;
	}
	
	@AfterThrowing("execution(* com.service.impl.CartServiceImpl.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		// 使用log4j记录日志
		System.out.println("发生异常");
		logger.error(joinPoint.toShortString() + "方法发送异常:");
	}
}

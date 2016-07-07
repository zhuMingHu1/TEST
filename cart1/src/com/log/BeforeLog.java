package com.log;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLog implements MethodBeforeAdvice{

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		
		System.out.println(target.getClass().getName()+"µÄ"+method.getName()+"±»Ö´ÐÐ¡£¡£");
	}
	
	
}

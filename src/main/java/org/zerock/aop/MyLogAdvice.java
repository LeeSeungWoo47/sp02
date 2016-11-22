package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger("ADVCIE");

	@Before("execution(* org.zerock.service.*.*(..))")
	public void startLog(JoinPoint jp){
		
		System.out.println("================");
		System.out.println("¹¹¹¹¹��");
		System.out.println(Arrays.toString(jp.getArgs()));
		System.out.println(jp.getSignature().getName());
		System.out.println("================");
	}
	
	@Around("execution(* org.zerock.service.*.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp){
		
		Object result = null;
		long start = System.currentTimeMillis();
		
		try{
			result = jp.proceed();
		}catch (Throwable e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		logger.info("TIME------------");
		logger.info("-------------"+ (end - start)+"----------");
		
		return result;
	}
}

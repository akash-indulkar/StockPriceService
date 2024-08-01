package com.akashxdev.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StockAop {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StockAop.class);
	
	@AfterThrowing("execution(* com.akashxdev.service.StockService.*(..)) || execution(* com.akashxdev.service.MyAdminDetailsService.*(..))")
	public void logMethodCrash(ProceedingJoinPoint jp) throws Throwable {
		jp.proceed();
		LOGGER.info("Wrong inputs " + jp.getSignature().getName());
	}
	
}

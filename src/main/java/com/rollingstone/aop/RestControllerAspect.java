package com.rollingstone.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@Aspect
@Component
public class RestControllerAspect {

private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	Counter genericAPICallCounter = Metrics.counter("com.rollingstone.controller.generic.controller.counter");

	@Before("execution(public * com.rollingstone.controller.*Controller.*(..))")
	public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
		logger.info(":::::AOP Before for Any Controller REST call:::::" + pjp);
		genericAPICallCounter.increment();
	}

}

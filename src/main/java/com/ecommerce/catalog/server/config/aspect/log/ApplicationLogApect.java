package com.ecommerce.catalog.server.config.aspect.log;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.ecommerce.catalog.server.config.ApplicationServerProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
//@EnableAspectJAutoProxy
public class ApplicationLogApect {

	@Autowired
	ApplicationServerProperties applicationServerProperties;

	@Around("controllerLevelLog()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		log.debug(
				applicationServerProperties.getApplicationName() + " =>"
						+ "REST-API Enter: method invoked class {}:{}() with argument[s] = {}",
				joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
				Arrays.toString(joinPoint.getArgs()));

		Object result = joinPoint.proceed();

		log.debug(
				applicationServerProperties.getApplicationName() + " =>"
						+ "REST-API Exit: method invoked class {}:{}() with result = {}",
				joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), result);

		return result;
	}

	@Pointcut(value = "execution(* com.ecommerce.catalog.server.controller.*.*(..) )")
	public void controllerLevelLog() {
	}

	@Pointcut(value = "execution(* com.ecommerce.catalog.server.delegates.*.*(..) )")
	public void delegateLevelLog() {
	}

	@Pointcut(value = "execution(* com.ecommerce.catalog.server.services.*.*(..) )")
	public void serviceLevelLog() {
	}

}

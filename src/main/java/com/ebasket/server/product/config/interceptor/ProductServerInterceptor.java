package com.ebasket.server.product.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProductServerInterceptor implements HandlerInterceptor {

	@Value("${spring.application.name}")
	private String applicationName;

	Logger logger = (Logger) LoggerFactory.getLogger(ProductServerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info(
				applicationName + " request url  preHandle - " + request.getMethod() + "  " + request.getRequestURI());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		/*
		 * log.info("ebasket-server-product request url postHandle - " +
		 * request.getMethod() + "  " + request.getRequestURI());
		 */
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		/*
		 * log.info("ebasket-server-product request url afterCompletion - " +
		 * request.getMethod() + "  " + request.getRequestURI());
		 */
	}

}

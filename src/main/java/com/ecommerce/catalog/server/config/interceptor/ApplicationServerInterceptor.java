package com.ecommerce.catalog.server.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.catalog.server.config.ApplicationServerProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationServerInterceptor implements HandlerInterceptor {

	@Autowired
	private ApplicationServerProperties applicationServerProperties;



	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		log.info(applicationServerProperties.getApplicationName() + " request url - {} {}", request.getMethod(),
				request.getRequestURI());

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

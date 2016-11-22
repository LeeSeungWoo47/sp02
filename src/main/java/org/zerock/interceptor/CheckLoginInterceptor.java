package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.web.HomeController;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		String requestPage = request.getRequestURI();
		
		session.setAttribute("R", requestPage);
		
		logger.info("START :" + requestPage);
		
		if(session.getAttribute("LOGIN") != null){

			logger.info("login!");
			
			
			return true;
			
		}
		
		logger.info("do login!");
		response.sendRedirect("login");
		return false;
	}

	
}

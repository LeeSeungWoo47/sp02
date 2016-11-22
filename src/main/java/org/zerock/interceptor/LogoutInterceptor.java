package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.web.HomeController;

public class LogoutInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("logout....");
		
		HttpSession session = request.getSession();
		
		String test = request.getRequestURI();
		
		logger.info("test : " + test);
		
		String login = session.getAttribute("LOGIN").toString();
		
		logger.info(login);
		
		if(login != null){
			
			session.removeAttribute("LOGIN");
			session.invalidate();
			
			response.sendRedirect("web/login");		
			
		}
		
		
		
		
	}

}

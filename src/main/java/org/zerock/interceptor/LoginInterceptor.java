package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.web.HomeController;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// controller에서 model에 답을 때 체크가능
 
		logger.info("loginInter");

		
		if (request.getMethod().equals("GET")) {
			return;
		}
		
		HttpSession session = request.getSession();

		Object value = modelAndView.getModel().get("value");

		if (value != null) {

			session.setAttribute("LOGIN", value);
			String requestPage = session.getAttribute("R").toString();
			
			response.sendRedirect(requestPage);
	
		}

	}

}

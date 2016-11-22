package org.zerock.web;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.service.ContentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private ContentService service;
	
	@GetMapping("/login")
	public void login(){
		logger.info("login get............");
	}
	
	@GetMapping("/myPage")
	public void myPage(){
		logger.info("myPage...get....");
	}
	
	@PostMapping("/login")
	public void login(String id, String pw, Model model){
		logger.info("login post...");
		logger.info("id:" + id);
		logger.info("pw:" + pw);
		model.addAttribute("value",id);
	}
	
	@PostMapping("/logout")
	public void logout(){

		logger.info("logout Post.....");
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		

		service.doA();
		service.doB();
		
		return "home";
	}
	
}

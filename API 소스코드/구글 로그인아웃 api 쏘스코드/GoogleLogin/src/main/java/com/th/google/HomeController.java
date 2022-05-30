package com.th.google;


import java.io.IOException;
import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	 GoogleController google;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	   google=new GoogleController();
		
		return "page1";
	}
	@RequestMapping(value = "/login.do", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Locale locale, Model model,String code) throws Exception {

	
		
	
	       
	       model.addAttribute("map",google.getUserInfo(google.getTocken(code)));
		
		return "page2";
	}
	
}

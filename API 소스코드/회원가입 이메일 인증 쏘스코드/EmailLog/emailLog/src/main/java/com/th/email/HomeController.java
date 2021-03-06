package com.th.email;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.th.mailSender.MailSender;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MailSender mailSender;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		return "page1";
	}
	@RequestMapping(value = "/page2", method = RequestMethod.GET)
	public String page2(Locale locale, Model model,String email,HttpServletRequest request) {

		mailSender.mailSendWithUserKey(email,"harry", request);
		
		
		return "page2";
	}
	@RequestMapping(value = "/page3", method = RequestMethod.GET)
	public String page3(Locale locale, Model model,String email,HttpServletRequest request) {
		
		
		return "page3";
	}
}

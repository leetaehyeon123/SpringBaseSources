package com.th.inter;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	@RequestMapping(value = {"/","/loginPage"}, method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {

		
		return "loginPage";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginDo(Locale locale, Model model,String id,HttpSession session) {
		session.setAttribute("id", id);
		
		return "redirect: mainPage";
	}
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public String mainPage(Locale locale, Model model) {

		
		return "mainPage";
	}
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutDo(Locale locale, Model model,HttpSession session) {
		session.setAttribute("id",null);

		
		return "redirect: loginPage";
	}
	@RequestMapping(value = "/notLogPage", method = RequestMethod.GET)
	public String notLogPage(Locale locale, Model model,HttpSession session) {

		
		return "notLogPage";
	}
}

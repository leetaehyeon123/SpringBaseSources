package com.th.kgn;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.th.api.FacebookLog;
import com.th.api.GoogleLog;
import com.th.api.KakaoLog;
import com.th.api.NaverLog;
import com.th.coolsms.Coolsms;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	FacebookLog fLog;
	@Autowired
	GoogleLog gLog;
	@Autowired
	NaverLog nLog;
	@Autowired
	KakaoLog kLog;
	

	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		
		return "home";
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {

		return "main";
	}

	
	
	
}

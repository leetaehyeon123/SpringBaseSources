package com.th.Naver;


import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	

	@Autowired
	NaverLogController naver;
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	   
		return "page1";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model,String code,HttpServletRequest request,HttpServletResponse response) throws Exception {
		 Cookie[] cookies = request.getCookies() ;
		    
		    if(cookies != null){
		        for(int i=0; i < cookies.length; i++){
		             
		            // 쿠키의 유효시간을 0으로 설정하여 만료시킨다
		            cookies[i].setMaxAge(0) ;
		             
		            // 응답 헤더에 추가한다
		            response.addCookie(cookies[i]) ;
		        }
		    } 
		String accessTocken=naver.getAccessTocken(code);
		model.addAttribute("map",naver.getUserInfo(accessTocken));
			model.addAttribute("loginUrl",naver.getLoginUrl());
		return "page2";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(Locale locale, Model model ) throws Exception {


	
		return "page3";
	}
	
	
}

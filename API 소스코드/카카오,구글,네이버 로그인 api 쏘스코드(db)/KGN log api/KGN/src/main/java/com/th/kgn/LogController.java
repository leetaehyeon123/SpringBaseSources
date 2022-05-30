package com.th.kgn;


import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.runtime.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.th.api.FacebookLog;
import com.th.api.GoogleLog;
import com.th.api.KakaoLog;
import com.th.api.NaverLog;
import com.th.dao.Dao;
import com.th.vo.Vo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LogController {
	
	@Autowired
	FacebookLog fLog;
	@Autowired
	GoogleLog gLog;
	@Autowired
	NaverLog nLog;
	@Autowired
	KakaoLog kLog;
	@Autowired
	Dao dao;
	
	
	//로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		model.addAttribute("kakaoLoginUrl", kLog.getLoginUrl());
		model.addAttribute("naverLoginUrl",nLog.getLoginUrl());
		model.addAttribute("googleLoginUrl",gLog.getLoginUrl());
		model.addAttribute("faceLoginUrl",fLog.getFaceUrl());
		
		return "page1";
	}
	//카카오 로그인 페이지
	@RequestMapping(value = "/kakaoLog.do", method = RequestMethod.GET)
	public String kakaoLog(Locale locale, Model model,String code) {
		return "redirect:login.do?platform=kakao&code="+code;
	}
	@RequestMapping(value = "/googleLog.do", method = RequestMethod.GET)
	public String googleLog(Locale locale, Model model,String code) throws Exception {
			return "redirect:login.do?platform=google&code="+code;		
	}
	@RequestMapping(value = "/naverLog.do", method = RequestMethod.GET)
	public String naverLog(Locale locale, Model model,String code) throws Exception {
		return "redirect:login.do?platform=naver&code="+code;
		
	}
	@RequestMapping(value = "/faceLog.do", method = RequestMethod.GET)
	public String faceLog(Locale locale, Model model,String code) throws Exception {
		return "redirect:login.do?platform=face&code="+code;
		
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String log(Locale locale, Model model,String code,String platform,HttpSession session) throws Exception {
		String returnPage="redirect:main";
		Vo vo=new Vo();
		ArrayList<Vo> list=new ArrayList<Vo>();
		String accessToken,userEmail;
		if(platform.equals("kakao")) {
			accessToken=kLog.getAccessToken(code);
			userEmail=kLog.getEmail(accessToken);	
			
		}else if(platform.equals("google")) {
			accessToken=gLog.getAccessToken(code);
			userEmail=gLog.getEmail(accessToken);	
			
		}else if(platform.equals("naver")) {
			accessToken=nLog.getAccessToken(code);
			userEmail=nLog.getEmail(accessToken);	
			
		}else{
			accessToken=fLog.getAccessToken(code);
			userEmail=fLog.getEmail(accessToken);	
		}
	
		vo.setPlatform(platform);
		vo.setEmail(userEmail);
		list=(ArrayList<Vo>)dao.selectEmail(vo);
		
		session.setAttribute("email", userEmail);
		session.setAttribute("platform", platform);
		if(list.size()==0) {
			returnPage="redirect:smsPage";
		}else {
			
			session.setAttribute("IdIdx", list.get(0).getIdx());
		}
		return returnPage;
		
		
	}
	@RequestMapping(value = "/signIn.do", method = RequestMethod.GET)
	public String sigIn(Locale locale, Model model,String email,String platform,String phoneNum,HttpSession session) {
		Vo vo=new Vo();
		ArrayList<Vo> list=new ArrayList<Vo>();
		vo.setEmail(email);
		vo.setPlatform(platform);
		vo.setPhoneNum(phoneNum);
		list=(ArrayList<Vo>)dao.selectPhoneNum(vo);
		if(list.size()==0) {
			dao.insert(vo);
		}else {
			dao.update(vo);
		}
		list=(ArrayList<Vo>)dao.selectPhoneNum(vo);

		session.setAttribute("IdIdx", list.get(0).getIdx());
		
		return "redirect:main";
	}
	

	
	
	//전체 로그아웃 페이지
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(Locale locale, Model model,HttpSession session) {
		session.setAttribute("IdIdx", null);
		session.setAttribute("email", null);
		session.setAttribute("platform", null);


		return "redirect:home";
	}

	
	
	
}

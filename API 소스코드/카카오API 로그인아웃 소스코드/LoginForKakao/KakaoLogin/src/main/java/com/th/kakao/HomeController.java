package com.th.kakao;


import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	
	KakaoController kakaoLogin;
	

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String login(Locale locale, Model model,HttpSession session) {//처음 카카오로그인 버튼이 있는 페이지이다.
		kakaoLogin=new KakaoController();
		  String kakaoUrl = kakaoLogin.getLoginUrl(session);
		  /* 생성한 카카오로그인 페이지 URL을 View로 전달 View에서 버튼을 누를시 location.href를 통해 그 페이지로 이동할 것이다.*/
		  model.addAttribute("kakao_url", kakaoUrl);//모델에 저장해서 View페이지에 보내준다.
		return "login";
	}
	@RequestMapping(value = "/page2.do", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	public String kakaoLogin(@RequestParam("code") String code,Model model) throws Exception {//카카오로그인 완료시 호출될 페이지 이다.
		String accessToken =kakaoLogin.getAccessToken(code);//받아온 code를 통해 토큰 검색을을 하고 거기서 accessToken 만 문자열로 추출해 왔다.
		HashMap<String , Object> map=kakaoLogin.getUserInfo(accessToken);//accessToken을 통해 사용자의 정보를 map형식으로 받아왔다.
		model.addAttribute("map",map);//사용자 정보가 담긴 map을 모델에 넣어 View로 보낸다.
		model.addAttribute("logoutUrl",kakaoLogin.getLogoutUrl());//로그아웃을 하는 페이지 URL을 모델에 담는다.
		return "page2";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {//로그아웃이 완로되면 호출될 페이지이다.
		return "logout";
	}
	
	
}

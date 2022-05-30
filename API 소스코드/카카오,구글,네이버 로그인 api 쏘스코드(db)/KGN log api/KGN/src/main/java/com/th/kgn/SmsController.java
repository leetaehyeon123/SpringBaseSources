package com.th.kgn;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.th.coolsms.Coolsms;

@Controller
public class SmsController {
	@RequestMapping(value = "/smsPage", method = RequestMethod.GET)
	public String smsPage() {


		return "smsPage";
	}

	@RequestMapping(value = "/smsPage.do", method = RequestMethod.GET)
	public void smsPageDo(Locale locale, Model model,String to,HttpSession session) {

		int code = (int)(Math.random()*998)+1111;
		session.setAttribute("code", code);
		
		
		//https://www.coolsms.co.kr/stat
		   String api_key = "NCSKIHYZ2UHQRCBN";
		    String api_secret = "B1BGGBULSY4IGFECPE44S3LJY4RDAEI3";
		    Coolsms coolsms = new Coolsms(api_key, api_secret);

		    HashMap<String, String> set = new HashMap<String, String>();
		    set.put("to", to); // 수신번호
		    set.put("from", "01045207141"); // 발신번호
		    set.put("text", "인증 번호 : ["+code+"]"); // 문자내용
		    set.put("type", "sms"); // 문자 타입

		    System.out.println(set);

		    try {
				coolsms.send(set);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 보내기&전송결과받기
	}

	@RequestMapping(value = "/smsIsCode.do", method = RequestMethod.GET)
	@ResponseBody
	public String smsIsCodeDo(Locale locale, Model model,HttpSession session,String code) {
	
		System.out.println(code+","+session.getAttribute("code"));
			if(session.getAttribute("code").toString().equals(code) && session.getAttribute("code")!=null) {
				return "true";
			}else {
				return "false";		
			}
	}
	

	
}

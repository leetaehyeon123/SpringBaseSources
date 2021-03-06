package com.th.sms;


import java.util.HashMap;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.th.coolsms.Coolsms;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "page1";
	}
	@RequestMapping(value = "/page2", method = RequestMethod.GET)
	public String page2(Locale locale, Model model,String to,String text) {

		//https://www.coolsms.co.kr/stat
		   String api_key = "NCSKIHYZ2UHQRCBN";
		    String api_secret = "B1BGGBULSY4IGFECPE44S3LJY4RDAEI3";
		    Coolsms coolsms = new Coolsms(api_key, api_secret);

		    HashMap<String, String> set = new HashMap<String, String>();
		    set.put("to", to); // 수신번호

		    set.put("from", "01045207141"); // 발신번호
		    set.put("text", text); // 문자내용
		    set.put("type", "sms"); // 문자 타입

		    System.out.println(set);

		    try {
				coolsms.send(set);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 보내기&전송결과받기

		return "page3";
	}

	
}

package com.th.ajax;


import java.util.ArrayList;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//page1�� �Խñ� �� ������ �������� page2�� ��۳����� ������ִ� ��������.
	
	
	ArrayList<ArrayList<String>> board_Num;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		board_Num=new ArrayList<ArrayList<String>>();
		for(int i=0;i<10;i++) {
		board_Num.add(new ArrayList<String>());
		}
		//db ��� ������ list�� ��ü�Ѵ�.
		//����: board_Num �ȿ� ����Ʈ 10���� �־��. board_Num.get(4)�� 4�� �Խñ��� ��۵� ����Ʈ�� ����ִ�. 
		
		return "page1";
	}
	@RequestMapping(value = "/page2", method = RequestMethod.GET)
	public String page2(Locale locale, Model model,String boardNum) {
		
		ArrayList<String> review=board_Num.get(Integer.parseInt(boardNum));
		//review�� boardNum�� �Խñ��� ����� ����ִ� ����Ʈ�� 
		review.add((Integer.parseInt(boardNum)+1)+"��° �Խñ� , "+(review.size()+1)+"��° ��� �ۼ�");
		
		model.addAttribute("review",review);
		
		return "page2";
	}
}

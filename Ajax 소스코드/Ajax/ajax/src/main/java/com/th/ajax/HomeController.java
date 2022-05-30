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
	//page1은 게시글 이 구현된 페이지고 page2는 댓글내용을 출력해주는 페이지다.
	
	
	ArrayList<ArrayList<String>> board_Num;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		board_Num=new ArrayList<ArrayList<String>>();
		for(int i=0;i<10;i++) {
		board_Num.add(new ArrayList<String>());
		}
		//db 대신 임의의 list로 대체한다.
		//구조: board_Num 안에 리스트 10개를 넣어둠. board_Num.get(4)는 4번 게시글의 댓글들 리스트가 들어있다. 
		
		return "page1";
	}
	@RequestMapping(value = "/page2", method = RequestMethod.GET)
	public String page2(Locale locale, Model model,String boardNum) {
		
		ArrayList<String> review=board_Num.get(Integer.parseInt(boardNum));
		//review는 boardNum번 게시글의 댓글이 들어있는 리스트다 
		review.add((Integer.parseInt(boardNum)+1)+"번째 게시글 , "+(review.size()+1)+"번째 댓글 작성");
		
		model.addAttribute("review",review);
		
		return "page2";
	}
}

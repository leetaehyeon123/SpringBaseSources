package com.lth.ajax;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


	//db를 대체할 구조
	//게시글 db
	ArrayList<HashMap<String,String>> board_list;
	HashMap<String,String> board_map;
	//댓글 db
	ArrayList<ArrayList<HashMap<String,String>>> review_boardNum;
	ArrayList<HashMap<String,String>> review_list;
	HashMap<String , String > review_map;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String page(Locale locale, Model model) {
		board_list=new ArrayList<HashMap<String,String>>();
		review_list=new ArrayList<HashMap<String,String>>();
		review_map = new HashMap<String, String>();	
		review_boardNum=new ArrayList<ArrayList<HashMap<String,String>>>();
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}
	@RequestMapping(value = "/loginSub", method = RequestMethod.GET)
	public void loginSub(Locale locale, Model model,HttpServletResponse response,HttpSession session,String id) {
		try {
			System.out.println(id);
			session.setAttribute("id", id);
			response.sendRedirect("main");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "mainForm";
	}
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model,String mode,String pageNum,String boardCon,String boardId) {
	System.out.println("pageNum : "+pageNum);
		if(mode!=null&&mode.equals("select")) {
			//pageNum
			model.addAttribute("list",board_list);
		}else if(mode.equals("insert")) {
			//boardCon
			//boardId
			board_map=new HashMap<String, String>();
			review_list=new ArrayList<HashMap<String,String>>();
			board_map.put("boardCon",boardCon);
			board_map.put("boardId",boardId);
			board_list.add(board_map);
			review_boardNum.add(review_list);
			model.addAttribute("list",board_list);
		}
		return "boardForm";
	}
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String review(Locale locale, Model model,String mode,String reviewCon,String reviewId,String boardNum) {
		ArrayList<HashMap<String,String>> list=review_boardNum.get(Integer.parseInt(boardNum));
		if(mode!=null&&mode.equals("select")) {

		}else if(mode.equals("insert")) {
		
			review_map=new HashMap<String, String>();
			review_map.put("reviewCon",reviewCon);
			review_map.put("reviewId", reviewId);
			list.add(review_map);
			
			
			

		}
		model.addAttribute("list",list);
		
		return "reviewForm";
	}
	
}

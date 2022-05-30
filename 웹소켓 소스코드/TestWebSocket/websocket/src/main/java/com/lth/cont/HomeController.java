package com.lth.cont;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


	@RequestMapping(value = {"/login","/"})
	public String login(HttpSession session) {	
		
		if(session.getAttribute("id")!=null) 
			session.setAttribute("id", null);
			
		return "login";
	}
	
	@RequestMapping(value = "/loginsub")
	public void chatting(HttpServletResponse response, HttpSession session,String roomId,String id) {
	session.setAttribute("id", id );
		
		try {
			response.sendRedirect("chatting?roomId="+roomId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/chatting")
	public String chatting(HttpSession session,String roomid) {	

		/*
		 * ���⼭ roomid�� ���� db�˻��� ���� ��ƿͼ� chatting jsp�� �Ѱ��ָ� ��
		 */
		return "chatting";
	}
	
	
}

package com.th.db;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.th.dao.Dao;
import com.th.vo.Vo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	ArrayList<Vo> list;
	
	@Autowired
	Vo vo;
	@Autowired
	Dao dao;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,String name) {

		return "main";
	}
	@RequestMapping(value = "/page1", method = RequestMethod.GET)
	public String page1(Locale locale, Model model,String name) {
	 System.out.println("search : "+name);
		if(name==null) {
			name="%%";
		}
		list=(ArrayList<Vo>)dao.select("%"+name+"%");
		model.addAttribute("list", list);
		return "page1";
	}
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert(Locale locale, Model model,String name) throws UnsupportedEncodingException {	
		vo.setName(name);
		dao.insert(vo);
		
		return "redirect:/page1?name="+URLEncoder.encode(name, "UTF-8");
	}
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(Locale locale, Model model,int idx,String name) throws UnsupportedEncodingException {	
		vo.setIdx(idx);
		dao.delete(vo);
		return "redirect:/page1?name="+URLEncoder.encode(name, "UTF-8");
	}
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(Locale locale, Model model,String searchName,int idx,String name) throws UnsupportedEncodingException {	
		vo.setIdx(idx);
		vo.setName(name);
		dao.update(vo);
		return "redirect:/page1?name="+URLEncoder.encode(searchName, "UTF-8");
	}
	
	
}

package com.nagarro.controller;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.dao.TshirtsDao;
import com.nagarro.dto.Tshirts;

@Controller
public class TshirtMain {
	
	private ApplicationContext conn;
	
	@RequestMapping("/register")
	public String view2(Model m) {
		
		CsvHelper ob= new CsvHelper();
		ob.CsvHelpers();
		
		conn=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Tshirts emp= conn.getBean("info", Tshirts.class);
		m.addAttribute("bean", emp);
		return "search";
	}
	
	

	
	
	@RequestMapping("/search")
	public String view6(@RequestParam String colour, @RequestParam String size,@RequestParam String gender,@RequestParam String preference, Model m) {
		conn=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		TshirtsDao obj=conn.getBean("dao", TshirtsDao.class);
		List list = obj.searchData(colour,size,gender,preference);
		
		if(!list.isEmpty()) {
			m.addAttribute("li", list);
		}
		else {
			m.addAttribute("msg","No records found!");
			
		}
		
		
		return "search";
		
	}
	
	

}

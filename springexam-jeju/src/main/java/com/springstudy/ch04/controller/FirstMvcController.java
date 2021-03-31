package com.springstudy.ch04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springstudy.ch04.service.FirstMvcService;


@Controller


@RequestMapping("/first")
public class FirstMvcController {
	
	@Autowired
	private FirstMvcService service;
	
	public void setFirstMvcService(FirstMvcService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value={"/", "/intro", "/index"}, method=RequestMethod.GET)
	public String index() {	
		
		return "/main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, HttpServletRequest request, 
			@RequestParam(value="num", defaultValue="1") int no, String id) {

		String msg = service.getMessage(no, id);
		model.addAttribute("msg", msg);
		
		model.addAttribute("title", "사진 디테일");
		model.addAttribute("comment", "제주도 새별오름 인근 나홀로나무입니다.");
		return "detail";
	}
}

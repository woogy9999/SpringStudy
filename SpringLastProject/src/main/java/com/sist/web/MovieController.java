package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;


@Controller
public class MovieController {
	@GetMapping("movie/list.do")
	public String movie_list(Model model) {
		
		model.addAttribute("main_jsp", "../movie/list.jsp");
		return "main/main";
	}
} 

package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;
import com.sist.mapper.FoodMapper;

@Controller
public class FoodController {

	@GetMapping("food/list.do")
	public String food_list() {
		
		return "food/list";
	}
	

}

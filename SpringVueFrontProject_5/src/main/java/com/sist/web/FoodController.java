package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@Controller
public class FoodController {
	
	@GetMapping("food/list.do")
	public String food_list() {
		
		return "food/list";
	}
	
	@GetMapping("food/detail.do")
	public String food_detail() {
		
		return "food/detail";
	}
}

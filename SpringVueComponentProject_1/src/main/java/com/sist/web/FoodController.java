package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/list.do")
	public String food_list() {
		
		return "food/list";
	}
	
	@RequestMapping("food/food_list.do")
	public String food_list2(String page,String ss,String[] fd,Model model) {
		
		if(page==null)
		page="1";
		
		int curpage=Integer.parseInt(page);
		
		
		Map map=new HashedMap();
		map.put("ss", ss);
		map.put("fdArr", fd);
		map.put("start", (12*curpage)-11);
		map.put("end", 12*curpage);

		List<FoodVO> list = dao.foodFindData(map);
		model.addAttribute("list", list);
		return "food/food_list";
	}
}

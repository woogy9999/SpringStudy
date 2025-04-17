package com.sist.web;

import org.apache.commons.collections.map.HashedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class FoodController {
	
	@Autowired
	private FoodDAO2 dao2;
	
	@GetMapping("food/list.do")
	public String food_list(String page,Model model) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);

		Map map=new HashedMap();
		map.put("pStart", (curpage*12)-11);
	    map.put("pEnd", curpage*12);
	    
		List<FoodVO> list=dao2.foodListData(map);
		int totalpage = dao2.foodTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "food/list";
	}
}

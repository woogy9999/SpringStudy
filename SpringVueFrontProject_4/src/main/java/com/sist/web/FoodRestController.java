package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.mapper.FoodMapper;
import com.sist.vo.*;
import java.util.*;


@RestController
public class FoodRestController {
	
	@Autowired
	private FoodDAO dao;
	
	@GetMapping(value = "food/food_list_vue",produces = "text/plain;charset=UTF-8")
	public String food_list_vue(int page) throws Exception{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		List<FoodVO> list=dao.foodListData(start, end);
		int totalpage=dao.foodTotalPage();
				
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
//		System.out.println(list.get(0));
//		for(FoodVO aa:list) {
//			System.out.println(aa);
//		}
		System.out.println(json);
		
		return json;
	}
	
	@GetMapping(value="food/food_find_vue.do",produces = "text/plain;charset=UTF-8")
	public String find_vue(int page,String fd) throws Exception{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		List<FoodVO> list=dao.foodFindData(map);
		int totalpage=dao.foodFindTotalPage(fd);
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
}

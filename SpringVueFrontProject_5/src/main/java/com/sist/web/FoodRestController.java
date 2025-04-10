package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

import java.util.*;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;

	private String[] titles = { "", "한식", "양식", "일식", "중식" };

	@GetMapping(value = "food/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_list(int page, int type) throws Exception {
		int rowSize = 12;
		int start = (rowSize * page) - (rowSize - 1);
		int end = (rowSize * page);

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("type", titles[type]);
		
		List<FoodVO> list = dao.foodListData(map);
		int totalpage = dao.foodTotalPage(map);

		map = new HashMap();
		map.put("totalpage", totalpage);
		map.put("curpage", page);
		map.put("list", list);

		final int BLOCK = 10;
		int startPage = ((page - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;
		if (endPage > totalpage)
			endPage = totalpage;

		map = new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);
		map.put("title", titles[type]);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);

		return json;
	}
	
	@GetMapping(value="food/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_detail(int fno) throws Exception{
		
		FoodVO vo=dao.foodDetailData(fno);
		
		String address=vo.getAddress();
		address=address.substring(address.indexOf(" ")+1);

		Map map=new HashMap();
		map.put("vo", vo);
		map.put("address", address.trim());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);

		return json;
	
	}
}

package com.sist.web;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.commons.CommonsPagination;
import com.sist.service.GoodsService;
import com.sist.vo.GoodsVO;

@Controller
public class MainController {
	@Autowired
	private GoodsService service;
	
	@GetMapping("main/main.do")
	public String main_main(String page, Model model) {
		
		
		Map map = CommonsPagination.pageConfig(page, 12);
		List<GoodsVO> list=service.goodsListData(map);
		int totalpage=service.goodsTotalPage();
		int curpage=(int)map.get("curpage");
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
		
	}
}

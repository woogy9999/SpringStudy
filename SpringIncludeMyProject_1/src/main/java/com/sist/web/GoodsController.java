package com.sist.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.commons.CommonsPagination;
import com.sist.service.GoodsService;
import com.sist.vo.GoodsVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService service;
	
	@GetMapping("goods/detail")
	public String goods_detail(int no,Model model) {
		

		GoodsVO vo=service.goodsDetailData(no);
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp","../goods/detail.jsp");
		return "main/main";
	}
	
	@RequestMapping("goods/find")
	public String goods_find(String page,String fd,Model model) {
		
		Map map=CommonsPagination.pageConfig(page, 12);
		
		int curpage=(int)map.get("curpage");
		
		if(fd==null)
			fd="프리";
		
		map.put("fd", fd);
		
		List<GoodsVO> list=service.goodsFindData(map);
		
		final int BLOCK = 10;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;
		int totalpage = service.goodsFindTotalPage(map);
		if (endPage > totalpage)
			endPage = totalpage;

		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("fd", fd); // JSP(X) => Ajax , Vue

		model.addAttribute("main_jsp", "../goods/find.jsp");
		return "main/main";
	}
}

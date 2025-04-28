package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.GoodsService;
import com.sist.vo.CartVO;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;

import java.util.*;

import javax.servlet.http.HttpSession;

@RestController
public class GoodsRestController {
	@Autowired
	private GoodsService service;

	@GetMapping("goods/list_vue.do")
	public Map goods_list(int page) {
		int rowSize = 12;

		List<GoodsVO> list = service.busanGoodsListData((page - 1) * rowSize, page * rowSize);
		int totalpage = service.busanGoodsTotalPage();

		final int BLOCK = 10;
		int startPage = ((page - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;

		if (endPage > totalpage)
			endPage = totalpage;

		Map map = new HashedMap();
		map.put("list", list);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("curpage", page);
		map.put("totalpage", totalpage);

		return map;

	}

	@GetMapping("goods/detail_vue.do")
	public GoodsVO goods_detail_vue(int no, Model model, HttpSession session) {

		GoodsVO vo = service.busanGoodsDetailData(no);
		return vo;
	}
	
	@PostMapping("goods/cart_insert.do")
	public String cart_insert(int gno,int account,HttpSession session) {
		String result="";
		String userid=(String)session.getAttribute("userid");
		CartVO vo=new CartVO();
		vo.setAccount(account);
		vo.setUserid(userid);
		vo.setGno(gno);
		
		try {
			service.goodsCartInsert(vo);
			result="yes";
		} catch (Exception e) {
			// TODO: handle exception
			result=e.getMessage();
		}
		return result;
	}
	
	@GetMapping("goods/buy_vue.do")
	public String goods_buy(int cno)
	{
		String result="";
		try {
			result="yes";
			service.goodsBuyUpdate(cno);
		} catch (Exception e) {
			result="no";
		}
		return result;
	}
	
}

package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;
@RestController
public class VueRestController {
  @Autowired
  private VueDAO dao;
  
  @GetMapping("food/list_vue.do")
  public Map food_list_vue(int page)
  {
	  Map map=new HashMap();
	  map.put("start", (page*12)-11);
	  map.put("end", page*12);
	  // WHERE num BETWEEN #{start} AND #{end}
	  List<FoodVO> list=dao.foodListData(map);
	  int totalpage=dao.foodTotalPage();
	  
	  // 블럭별 페이지 처리 
	  final int BLOCK=10;
	  int startPage=((page-1)/BLOCK*BLOCK)+1;
	  // 1 11 21...
	  int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	  // 10 20 30....
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  // 출력에 필요한 데이터를 모아서 => Vue 
	  map=new HashMap();
	  map.put("totalpage", totalpage);
	  map.put("curpage", page);
	  map.put("list", list);
	  map.put("startPage", startPage);
	  map.put("endPage",endPage);
	  // => Vue의 멤버변수=> data(){} 
	  return map;
	  
  }
  
  @GetMapping("food/detail_vue.do")
  public FoodVO food_detail(int fno)
  {	
	  FoodVO vo=dao.foodDetailData(fno);
	  return vo;
  }
  
  
  @GetMapping("goods/list_vue.do")
  public Map goods_list_vue(int page)
  {
	  Map map=new HashMap();
	  map.put("start", (page*12)-11);
	  map.put("end", page*12);
	  // WHERE num BETWEEN #{start} AND #{end}
	  List<GoodsVO> list=dao.goodsListData(map);
	  int totalpage=dao.goodsTotalPage();
	  
	  // 블럭별 페이지 처리 
	  final int BLOCK=10;
	  int startPage=((page-1)/BLOCK*BLOCK)+1;
	  // 1 11 21...
	  int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	  // 10 20 30....
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  // 출력에 필요한 데이터를 모아서 => Vue 
	  map=new HashMap();
	  map.put("totalpage", totalpage);
	  map.put("curpage", page);
	  map.put("list", list);
	  map.put("startPage", startPage);
	  map.put("endPage",endPage);
	  // => Vue의 멤버변수=> data(){} 
	  return map;
	  
  }
  
  @GetMapping("goods/detail_vue.do")
  public Map goods_detail(int no)
  {	
	  
	  Map map=new HashMap();
	  GoodsVO vo=dao.goodsDetailData(no);
	  String temp=vo.getGoods_price();
	  temp=temp.replaceAll("[^0-9]", "");
	  int price=Integer.parseInt(temp);
	  
	  map.put("detail", vo);
	  map.put("price", price);
	  return map;
  }
}
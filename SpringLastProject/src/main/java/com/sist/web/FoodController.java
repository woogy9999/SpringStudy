package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.*;
import com.sist.vo.*;
@Controller
@RequestMapping("food/")
public class FoodController {
	   @Autowired
	   private FoodService service;
	   
  @GetMapping("list.do")
  public String food_list(Model model)
  {
	  model.addAttribute("main_jsp", "../food/list.jsp");
	  return "main/main";
  }
  /*
   * 
   * 
   * 	@RestController
   */
  @GetMapping("detail.do")
  public String food_detail(int fno,Model model)
  {

	   FoodVO vo=service.busanFoodDetailData(fno);
	   List<String> list=new ArrayList<String>();
	   String[] images=vo.getImages().split(",");
	   list=Arrays.asList(images); // 배열을 리스트로 변경할떄 asList
	   model.addAttribute("vo",vo);
	   model.addAttribute("list",list);
	   
	  model.addAttribute("main_jsp", "../food/detail.jsp");
	  return "main/main";
  }
  
}

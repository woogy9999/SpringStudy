package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.BusanInfoService;
import java.util.*;

@Controller
public class BusanInfoController {
	@Autowired 
	private BusanInfoService service;
	
	private String[] titles= {"","명소","음식","쇼핑"};
	// HandlerMapping이 찾기 => 기능 설정
	@GetMapping("busan/info.do")
	public String busan_info(String page,int cno,Model model) {
		
		// include할 파일 전송
		model.addAttribute("cno",cno);
		model.addAttribute("titles",titles[cno]);
		model.addAttribute("main_jsp","../busan/info_list.jsp");
		return "main/main";
	}
	
}

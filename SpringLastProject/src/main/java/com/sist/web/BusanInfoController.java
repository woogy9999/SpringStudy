package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.BusanInfoService;
import com.sist.vo.BusanInfoVO;

import java.util.*;

import javax.servlet.http.HttpSession;

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
		System.out.println(titles[cno]);
		model.addAttribute("main_jsp","../busan/info_list.jsp");
		return "main/main";
	}
	
	@GetMapping("busan/detail.do")
	public String busan_detail(int no,Model model,HttpSession session) {
		
		String id=(String)session.getAttribute("userid");
		BusanInfoVO vo=service.busanInfoDetailData(no);
		
		String addr1=vo.getAddress();
		addr1=addr1.substring(addr1.indexOf(" "));
		String addr2=addr1.trim();
		addr2=addr2.substring(0,addr2.indexOf(" "));
		
		model.addAttribute("vo",vo);
		model.addAttribute("sessionId",id);
		model.addAttribute("addr",addr2);
		model.addAttribute("main_jsp","../busan/info_detail.jsp");
		return "main/main";
	}
	
}

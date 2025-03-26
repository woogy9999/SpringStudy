package com.sist.web;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.service.*;

// JSP로 요청 처리 결과값 전송
@Controller
@RequestMapping("food/")
public class FoodRecipeController {
	@Autowired
	private FoodRecipeService service;
	
	// 목록 => 405
	
	/*
	  	404 파일 찾기 오류
	  	405 get /post
	  	500 db
	  	400 bad request
	 
	 */
	@GetMapping("food_list.do") // Target : Method
	public String food_list(String page,Model model) {
		
        if (page == null) {
        	page = "1";
        }
        int curpage = Integer.parseInt(page);
        HashMap map=new HashMap();
        int rowSize=12;
        int start=(rowSize*curpage)-(rowSize-1);
        int end=(rowSize*curpage);
        map.put("start", start);
        map.put("end", end);
        
        List<FoodVO> list = service.foodListData(map);
        int totalpage=service.foodTotalPage();
        
        final int BLOCK=10;
        int startPage=((curpage-1)/BLOCK*BLOCK)+1;
        int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
        if(endPage>totalpage)
        	endPage=totalpage;
        
        model.addAttribute("list", list);
        model.addAttribute("curpage", curpage);
        model.addAttribute("totalpage", totalpage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        
		return "food/food_list";
	}
	
	
	// 쿠키
	@GetMapping("food_detail_before.do")
	public String food_detail_before(String fno, Model model, HttpServletResponse response,RedirectAttributes ra) {
		
			Cookie cookie = new Cookie("spring_" + fno, fno);
	        cookie.setPath("/");
	        cookie.setMaxAge(60 * 60 * 24); // 1일
	        response.addCookie(cookie);
	        
	        ra.addAttribute("fno", fno);
	        return "redirect:food_detail.do";
	}
	
	// 상세보기
	@GetMapping("food_detail.do")
	public String food_detail(int fno,Model model) {
		   // 상세 데이터 조회
        FoodVO vo = service.foodDetailData(fno);
        model.addAttribute("vo", vo);
        
        return "food/food_detail";
	}
	
	 // 최근 본 음식 목록 (쿠키 읽기)
//    @GetMapping("food_recent.do")
//    public String food_recent(HttpServletRequest request, Model model) {
//        Cookie[] cookies = request.getCookies();
//        List<FoodVO> rList = new ArrayList<>();
//
//        if (cookies != null) {
//            for (int i = cookies.length - 1; i >= 0; i--) {
//                if (cookies[i].getName().startsWith("spring_")) {
//                    try {
//                        int fno = Integer.parseInt(cookies[i].getValue());
//                        FoodVO vo = service.foodDetailData(fno);
//                        rList.add(vo);
//                    } catch (Exception e) {
//                        e.printStackTrace(); // 예외 무시
//                    }
//                }
//            }
//        }
//
//        model.addAttribute("rList", rList);
//        return "food/food_recent";
//    }
	
}

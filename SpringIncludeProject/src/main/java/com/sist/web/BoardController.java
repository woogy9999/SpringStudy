package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.service.*;
import com.sist.vo.*;

import java.text.SimpleDateFormat;
import java.util.*;
@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("replyboard/list.do")
	public String board_list(String page,Model model) {
		
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData(curpage);
		int count=dao.boardRowCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((curpage*10)-10);
		
		String msg="관리자가 삭제한 게시물입니다";
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		model.addAttribute("msg",msg);
		model.addAttribute("today",today);
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("count", count);
		
		model.addAttribute("main_jsp", "../replyboard/list.jsp");
		return "main/main";
	}
	
	@GetMapping("replyboard/insert.do")
	public String board_insert(Model model) {
		
		model.addAttribute("main_jsp", "../replyboard/insert.jsp");
		return "main/main";
	}
	@PostMapping("replyboard/insert_ok.do")
	public String board_insert_ok(BoardVO vo) {
		dao.boardInsert(vo);
		return "redirect:../replyboard/list.do";
	}
	
	@GetMapping("replyboard/detail.do")
	public String board_detail(int no,Model model) {
		 
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp", "../replyboard/detail.jsp");
		return "main/main";
		
	}
	@GetMapping("replyboard/update.do")
	public String board_update(int no,Model model) {

		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp", "../replyboard/update.jsp");
		return "main/main";
	}
	
	@GetMapping("replyboard/reply.do")
	public String board_reply(int no,Model model) {
		
		model.addAttribute("no",no);
		model.addAttribute("main_jsp", "../replyboard/reply.jsp");
		return "main/main";
	}
	@PostMapping("replyboard/reply_ok.do")
	public String board_reply_ok(int pno,BoardVO vo) {
		
		dao.replyInsert(pno, vo);
		return "redirect:../replyboard/list.do";
	}
	
	@GetMapping("replyboard/delete.do")
	public String board_delete(int no,Model model) {
		
		model.addAttribute("no",no);
		model.addAttribute("main_jsp", "../replyboard/delete.jsp");
		return "main/main";
		
	}
	
	
}

package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.CommentService;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.service.*;

@RestController
public class ConmmentRestController {
	@Autowired
	private CommentService service;

	public Map commontListData(int page, int cno, int type) {
		Map resultMap = new HashedMap();

		int rowSize = 10;
		int start = (page - 1) * rowSize;
		int end = (page * rowSize);
		Map Map = new HashMap();
		Map.put("start", start);
		Map.put("end", end);
		Map.put("cno", cno);
		Map.put("type", type);

		List<CommentVO> list = service.commentListData(Map);
		int totalpage = service.commentTotalPage(cno, type);

		final int BLOCK = 5;
		int startPage = ((page - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;
		if (endPage > totalpage)
			endPage = totalpage;

		Map = new HashMap();
		Map.put("list", list);
		Map.put("startPage", startPage);
		Map.put("endPage", endPage);
		Map.put("totalpage", totalpage);
		Map.put("curpage", page);

		return Map;
	}
	
	//목록
	@GetMapping("comment/list_vue.do")
	public Map comment_list(int page, int cno, int type) {
		return comment_list(page, cno, type);
	}
	//추가
	@PostMapping("commment/insert_vue.do")
	public Map comment_insert(CommentVO vo, HttpSession session) {
		String userid=(String)session.getAttribute("userid");
		String username=(String)session.getAttribute("username");
		String sex=(String)session.getAttribute("sex");
		vo.setUserid(userid);
		vo.setUsername(username);
		vo.setSex(sex);
		
		service.commentInsert(vo);
		return commontListData(1, vo.getCno(), vo.getType());
		
	}
	//수정
	//삭제
	//대댓글
}

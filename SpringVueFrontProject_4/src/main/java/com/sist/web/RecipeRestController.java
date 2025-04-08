package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*	
 	REST API
 	get		SELECT
 	post	INSERT
 	put		UPDATE
 	delete	DELETE

  	화면이동이 불가능
  	JavaScript연동 => 처리 결과값을 전송
  	-------------- JSON -> 자바스크립트 오브젝트
  	일반 문자열 => 그냥 전송
  	VO => {} => 자바스크립트의 객체 표현법
  	List => []
 
 
 */

import com.sist.vo.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
 
@RestController
public class RecipeRestController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping(value="recipe/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String recipe_list_vue(int page) throws Exception{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		List<RecipeVO> list=dao.recipeListData(start,end);
		int totalpage=dao.recipeTotalPage();
		
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		// JSON 변환 => 자바스크립트에서 인식
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	/*
						params:{
							// ?page=1&fd=마포  앞에가 키 , 뒤에가 값
							page:this.curpage,
							fd:this.fd
						}
	 */
	@GetMapping(value="recipe/find_vue.do",produces = "text/plain;charset=UTF-8")
	public String find_vue(int page,String fd) throws Exception{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		List<RecipeVO> list=dao.recipeFindData(map);
		int totalpage=dao.recipeFindTotalPage(fd);
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	@GetMapping(value="recipe/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String detail_vue(int no) throws Exception{
		RecipeDetailVO vo=dao.recipeDetailData(no);
		List<String> mList=new ArrayList<String>();
		List<String> iList=new ArrayList<String>();
		String data = vo.getFoodmake();
		String[] makes = data.split("\\\\n");

		for (String m : makes) {
			StringTokenizer st = new StringTokenizer(m, "^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		Map map=new HashMap();
		map.put("vo", vo);
		map.put("mList", mList);
		map.put("iList", iList);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);

		return json;
	}
}

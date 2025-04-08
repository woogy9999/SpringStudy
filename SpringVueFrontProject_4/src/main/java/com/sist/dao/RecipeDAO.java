package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
//	public List<RecipeVO> recipeListData(@Param("start") int start,@Param("end") int end);
//	
//	
//	public int recipeTotalPage();
	public List<RecipeVO> recipeListData(int start,int end){
		return mapper.recipeListData(start, end);
	}
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	
	/*
	 * 	public List<RecipeVO> recipeFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE title LIKE '%'||#{fd}||'%'")
	public int recipeFindTotalPage(String fd);
	 */
	public List<RecipeVO> recipeFindData(Map map){
		return mapper.recipeFindData(map);
	}
	public int recipeFindTotalPage(String fd) {
		return mapper.recipeFindTotalPage(fd);
	}
	public RecipeDetailVO recipeDetailData(int no) {
		return mapper.recipeDetailData(no);
		
	}
	
}

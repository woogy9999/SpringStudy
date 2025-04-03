package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

public interface RecipeService {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeTotalPage();
	
	public RecipeDetailVO recipeDetailData(int no);
	
	public List<RecipeVO> recipeFindData(Map map);
	public int recipeFindTotalPage(Map map);
	
	
	/*
	 * public List<ChefVO> chefListData(Map map){
		return mapper.chefListData(map);
	}
	
	public int chefTotalPage() {
		return mapper.chefTotalPage();
				
	}
	 */
	
	public List<ChefVO> chefListData(Map map);
	public int chefTotalPage();
}

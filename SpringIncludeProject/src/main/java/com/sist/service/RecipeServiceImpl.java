package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
@Service // 여러개의 DAO를 통합해서 사용
public class RecipeServiceImpl implements RecipeService{

	
	@Autowired
	private RecipeDAO rDao;
	@Autowired
	private RecipeDetailDAO dDao;
	
	@Override
	public List<RecipeVO> recipeListData(Map map) {
		return rDao.recipeListData(map);
	}

	@Override
	public int recipeTotalPage() {
		return rDao.recipeTotalPage();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return dDao.recipeDetailData(no);
	}

	 
	@Override
	public List<RecipeVO> recipeFindData(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeFindData(map);
	}

	@Override
	public int recipeFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeFindTotalPage(map);
	}

	@Override
	public List<ChefVO> chefListData(Map map) {
		// TODO Auto-generated method stub
		return rDao.chefListData(map);
	}

	@Override
	public int chefTotalPage() {
		// TODO Auto-generated method stub
		return rDao.chefTotalPage();
	}

}

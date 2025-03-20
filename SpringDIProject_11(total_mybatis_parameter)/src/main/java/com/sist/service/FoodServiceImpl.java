package com.sist.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO fDao;
	
	public List<FoodVO> foodListData(@Param("start")int start,@Param("end")int end){
		return fDao.foodListData(start, end);
	}

	public int foodTotalPage() {
		return fDao.foodTotalPage();
	}
	
}

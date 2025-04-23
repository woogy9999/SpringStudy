package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;
import com.sist.mapper.*;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> busanGoodsListData(int start, int end) {
		return mapper.busanGoodsListData(start, end);
	}

	public int busanGoodsTotalPage() {
		return mapper.busanGoodsTotalPage();
				
	}

	public GoodsVO busanGoodsDetailData(int no) {
		return mapper.busanGoodsDetailData(no);
	}
}

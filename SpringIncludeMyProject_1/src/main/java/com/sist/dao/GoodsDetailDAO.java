package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsDetailMapper;
import com.sist.vo.GoodsVO;

@Repository
public class GoodsDetailDAO {
	@Autowired
	private GoodsDetailMapper mapper;
	
	/*
	 * 	@Select("SELECT * FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	 */
	
	public GoodsVO goodsDetailData(int no) {
		return mapper.goodsDetailData(no);
	}
}

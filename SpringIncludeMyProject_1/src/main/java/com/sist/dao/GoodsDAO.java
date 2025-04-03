package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.mapper.GoodsMapper;
import com.sist.vo.BoardVO;
import com.sist.vo.GoodsVO;

@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;

	
	/*
	 * 	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(goods_all gm_no_pk)no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster "
			+ "FROM goods_all )) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	 */
	
	public List<GoodsVO> goodsListData(Map map){
		return mapper.goodsListData(map);
	}
	
	public int goodsTotalPage() {
		return mapper.goodsTotalPage();
	}
	
	/*
	 * public List<GoodsVO> goodsAsideData();
	 */
	public List<GoodsVO> goodsAsideData(){
		return mapper.goodsAsideData();
	}
	
	/*
	public List<GoodsVO> goodsFindData(Map map);
	
	public int goodsFindTotalPage(Map map);
	 */
	public List<GoodsVO> goodsFindData(Map map){
		return mapper.goodsFindData(map);
	}
	
	public int goodsFindTotalPage(Map map) {
		return mapper.goodsFindTotalPage(map);
	}
	
	
	
}

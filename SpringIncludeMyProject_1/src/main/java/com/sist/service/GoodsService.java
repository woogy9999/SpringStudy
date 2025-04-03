package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.BoardVO;
import com.sist.vo.GoodsVO;

public interface GoodsService {

	
	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage();
	public GoodsVO goodsDetailData(int no);

	
	/*
	 * public List<GoodsVO> goodsFindData(Map map){
		return mapper.goodsFindData(map);
	}
	
	public int goodsFindTotalPage(Map map) {
		return mapper.goodsFindTotalPage(map);
	}
	 */
	public List<GoodsVO> goodsFindData(Map map);
	public int goodsFindTotalPage(Map map);
	
	
	
	public List<BoardVO> boardListData(Map map);
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);
	public BoardVO boardUpdateData(int no);
}

package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.BoardDAO;
import com.sist.dao.GoodsDAO;
import com.sist.dao.GoodsDetailDAO;
import com.sist.vo.BoardVO;
import com.sist.vo.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDAO gDao;
	@Autowired
	private GoodsDetailDAO dDao;
	
	@Autowired
	private BoardDAO bDao;
	
	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.goodsTotalPage();
	}

	@Override
	public GoodsVO goodsDetailData(int no) {
		// TODO Auto-generated method stub
		return dDao.goodsDetailData(no);
	}

	@Override
	public List<GoodsVO> goodsFindData(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsFindData(map);
	}

	@Override
	public int goodsFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsFindTotalPage(map);
	}

	@Override
	public List<BoardVO> boardListData(Map map) {
		// TODO Auto-generated method stub
		return bDao.boardListData(map);
	}

	@Override
	public int boardRowCount() {
		// TODO Auto-generated method stub
		return bDao.boardRowCount();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		bDao.boardInsert(vo);
		
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		return bDao.boardDetailData(no);
	}

	@Override
	public BoardVO boardUpdateData(int no) {
		// TODO Auto-generated method stub
		return bDao.boardUpdateData(no);
	}

}

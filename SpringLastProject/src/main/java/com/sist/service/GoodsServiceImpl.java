package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.CartVO;
import com.sist.vo.GoodsVO;
import com.sist.dao.*;
@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDAO gDao;
	
	@Autowired
	private CartDAO cDao;
	
	@Override
	public List<GoodsVO> busanGoodsListData(int start, int end) {
		// TODO Auto-generated method stub
		return gDao.busanGoodsListData(start, end);
	}

	@Override
	public int busanGoodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.busanGoodsTotalPage();
	}

	@Override
	public GoodsVO busanGoodsDetailData(int no) {
		// TODO Auto-generated method stub
		return gDao.busanGoodsDetailData(no);
	}

	@Override
	public void goodsCartInsert(CartVO vo) {
		// TODO Auto-generated method stub
		int count=cDao.goodsCartGnoCount(vo);
		if(count==0)
		{
			cDao.goodsCartInsert(vo);
		}
		else {
			cDao.goodsAccountUpdate(vo);
		}
	}


	@Override
	public List<CartVO> goodsCartListData(String userid) {
		// TODO Auto-generated method stub
		return cDao.goodsCartListData(userid);
	}

	
	@Override
	public List<CartVO> goodsBuyListData(String userid) {
		// TODO Auto-generated method stub
		return cDao.goodsBuyListData(userid);
	}

	@Override
	public void goodsCartCancel(int cno) {
		// TODO Auto-generated method stub
		cDao.goodsCartCancel(cno);
		
	}

	@Override
	public void goodsBuyUpdate(int cno) {
		// TODO Auto-generated method stub
		cDao.goodsBuyUpdate(cno);
	}

}

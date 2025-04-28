package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class CartDAO {
	@Autowired
	private CartMapper mapper;
	
	   public void goodsCartInsert(CartVO vo) {
		   mapper.goodsCartInsert(vo);
	   }
	   public int goodsCartGnoCount(CartVO vo) {
		   return mapper.goodsCartGnoCount(vo);
	   }
	   
	   public void goodsAccountUpdate(CartVO vo) {
		   mapper.goodsAccountUpdate(vo);
	   }
	   
	   public List<CartVO> goodsCartListData(String userid){
		   return mapper.goodsCartListData(userid);
	   }
	   
	   public List<CartVO> goodsBuyListData(String userid){
		   return mapper.goodsBuyListData(userid);
	   }
	   public void goodsCartCancel(int cno) {
		   mapper.goodsCartCancel(cno);
	   }
	   
	   public void goodsBuyUpdate(int cno) {
		   mapper.goodsBuyUpdate(cno);
	   }
}

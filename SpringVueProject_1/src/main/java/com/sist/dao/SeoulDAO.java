package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class SeoulDAO {
   @Autowired
   private SeoulMapper mapper;
   
   public List<SeoulVO> seoulListData(Map map)
   {
      return mapper.seoulListData(map);
   } 
   public int seoulTotalPage(Map map)
   {
      return mapper.seoulTotalPage(map);
   }
    public List<FoodVO> foodRecommendData(String address)
    {
      return mapper.foodRecommendData(address);
    }   
    public SeoulVO seoulLocationDetailData(int no)
    {
  	  return mapper.seoulLocationDetailData(no);
    } 

}   

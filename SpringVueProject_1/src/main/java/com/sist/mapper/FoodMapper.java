package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	   @Select("SELECT fno,poster,name,num "
			  +"FROM (SELECT fno,poster,name,rownum as num "
			  +"FROM (SELECT fno,poster,name "
			  +"FROM project_food ORDER BY fno ASC)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")
	   public List<FoodVO> foodListData(@Param("start") int start,
			   @Param("end") int end);
	   @Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	   public int foodTotalPage();
	   
	   @Select("SELECT * FROM project_food "
	   		+ "WHERE fno=#{fno}")
	   public FoodVO foodDetailData(int fno);
}
package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {

	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT fno,name,poster "
		    + "FROM project_food WHERE type = #{type} ORDER BY fno ASC)) "
		    + "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM project_food WHERE type = #{type}")
	public int foodTotalPage(Map map);
	
	@Select("SELECT * FROM project_food "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
}

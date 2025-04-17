package com.sist.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import com.sist.vo.*;
import java.util.*;
public interface FoodMapper {

	
	
	/*	<select id="foodTotalPage" resultType="int">
	  SELECT CEIL(COUNT(*) / 12.0) FROM project_food
	</select>
	*/
	public int foodTotalPage();
	
	
	@Select(value="{CALL foodListData(#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR, resultMap=foodMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<FoodVO> foodListData(Map map);

}

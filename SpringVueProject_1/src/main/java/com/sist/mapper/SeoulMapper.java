package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
import com.sist.vo.SeoulVO;

public interface SeoulMapper {
	@Select("SELECT no,poster,title,num "
			+ "FROM (SELECT no,poster,title,rownum as num "
			+ "FROM (SELECT no,poster,title "
		    + "FROM ${table_name} ORDER BY no ASC)) "
		    + "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM ${table_name}")
	public int seoulTotalPage(Map map);

	// 인근맛집
	@Select("SELECT fno,poster,name,rownum "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM project_food "
			+ "WHERE address LIKE '%'||#{address}||'%' "
			+ "ORDER BY hit DESC) "
			+ "WHERE rownum <= 8")
	public List<FoodVO> foodRecommendData(String address);
	   
	@Select("SELECT * FROM seoul_location "
			   +"WHERE no=#{no}")
	public SeoulVO seoulLocationDetailData(int no); 
} 

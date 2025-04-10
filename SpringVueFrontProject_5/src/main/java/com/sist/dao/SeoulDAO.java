package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	/*
	 * @Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM ${table_name} ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end} ")
		public List<SeoulVO> seoulListData(Map map);
	
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
		public int seoulTotalPage(Map map);
	 */
	public List<SeoulVO> seoulListData(Map map){
		return mapper.seoulListData(map);
	}
	public int seoulTotalPage(Map map) {
		return mapper.seoulTotalPage(map);
	}
	public SeoulVO seoulDetailData(Map map) {
		return mapper.seoulDetailData(map);
	}
}

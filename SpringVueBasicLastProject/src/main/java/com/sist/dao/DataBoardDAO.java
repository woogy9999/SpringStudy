package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	/*
	 * public List<DataBoardVO> databoardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM vueDataBoard")
	public int databoardTotalPage();
	
	@Insert("INSERT INTO vueDataBoard VALUES("
			+ "vb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filename},#{filesize},"
			+ "#{filecount},0")
	public void databoardInsert(DataBoardVO vo);
	 */
	
	public List<DataBoardVO> databoardListData(Map map){
		return mapper.databoardListData(map);
	}
	public int databoardTotalPage() {
		return mapper.databoardTotalPage();
	}
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	/*
	 * 
	 * 	@Update("UPDATE vueDataBoard SET hit = hit + 1 WHERE no = #{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no, name, subject, content, TO_CHAR(regdate,'yyyy-mm-dd') as dbday, hit, filename, filesize, filecount " +
	        "FROM vueDataBoard WHERE no = #{no}")
	public DataBoardVO databoardDetail(int no);
	 */
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
}

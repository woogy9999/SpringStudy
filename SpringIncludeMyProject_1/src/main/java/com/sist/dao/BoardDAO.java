package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private BoardMapper mapper;
	
	/*

	@Select("SELECT no,subject,name,hit,regdate,num "
			+ "FROM (SELECT no,subject,name,hit,regdate,rownum as num "
			+ "FROM (SELECT no,subject,name,hit,regdate "
			+ "FROM springReplyBoard ORDER BY no DESC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(int page);
	
	
	@Select("SELECT COUNT(*) FROM springReplyBoard ")
	public int boardRowCount();
	
	
	@Insert("INSERT INTO springReplyBoard("
			+"no,name,subject,content,pwd,group_id) "
			+ "VALUES(srb_no_seq.nextval,?,?,?,?, "
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard)) ")
	public void boardInsert(BoardVO vo);
	
//	@Update("UPDATE springReplyBoard SET "
//			+ "hit=hit+1 "
//			+ "WHERE no=#{no}")
//	public BoardVO boardDetailData(int no);
	
	
	@Update("UPDATE springReplyBoard SET hit=hit+1 WHERE no=#{no}")
	public void boardHitIncrement(int no);

	@Select("SELECT no, name, subject, content, hit, regdate "
	      + "FROM springReplyBoard WHERE no = #{no}")
	public BoardVO boardDetailData(int no);
	
	@Select("SELECT no, name, subject, content, hit, regdate "
			+ "FROM springReplyBoard WHERE no = #{no}")
	public BoardVO boardUpdateData(int no);

	 */
	
	public List<BoardVO> boardListData(Map map){
		return mapper.boardListData(map);
	}
	public int boardRowCount() {
		return mapper.boardRowCount();
	}
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);;
	}
//	public void boardHitIncrement(int no) {
//		mapper.boardHitIncrement(no);
//	}
	
	@Transactional
	public BoardVO boardDetailData(int no) {
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
	public BoardVO boardUpdateData(int no) {
		return mapper.boardUpdateData(no);
	}
}

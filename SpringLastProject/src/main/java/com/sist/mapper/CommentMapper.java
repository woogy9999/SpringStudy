package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface CommentMapper {
	// 목록
	@Select("SELECT no, cno, type, userid, username, sex, msg, "
			  + "TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') AS dbday, "
			  + "group_id, group_step, num "
			  + "FROM (SELECT no, cno, type, userid, username, sex, msg, regdate, group_id, group_step, rownum as num "
			  + "FROM (SELECT no, cno, type, userid, username, sex, msg, regdate, group_id, group_step "
			  + "FROM busanReply "
			  + "WHERE cno=#{cno} AND type=#{type} "
			  + "ORDER BY group_id DESC, group_step ASC)) "
			  + "WHERE num BETWEEN #{start} AND #{end}")
	public List<CommentVO> commentListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM busanReply "
			+ "WHERE cno=#{cno} AND type=#{type}")
	public int commentTotalPage(@Param("cno") int cno, @Param("type") int type);
	
	// 2. 댓글 등록
	@Insert("INSERT INTO busanReply(no, cno, type, userid, username, sex, msg, group_id) "
		      + "VALUES((SELECT NVL(MAX(no)+1,1) FROM busanReply), "
		      + "#{cno}, #{type}, #{userid}, #{username}, #{sex}, #{msg}, "
		      + "(SELECT NVL(MAX(group_id)+1,1) FROM busanReply))")
	public void commentInsert(CommentVO vo);

	
	// 3. 댓글 수정
	@Update("UPDATE busanReply SET msg=#{msg} WHERE no=#{no}")
	public void commentUpdate(@Param("msg") String msg, @Param("no") int no);
	
//	// 4. 댓글 삭제
//	@Delete("DELETE FROM busanReply WHERE no=#{no}")
//	public void commentDelete(int no);
	
	//대댓글
	@Select("SELECT group_id,group_step "
			+ "FROM busanReply "
			+ "WHERE no=#{no}")
	public CommentVO commentParentInfoData(int no);
	
	@Update("UPDATE busanReply SET "
			+ "group_step=group_step+1 "
			+ "WHERE group_id=#{group_id} AND group_step>#{group_step}")
	public void commentGroupStepIncrement(CommentVO vo);
	
	  @Insert("INSERT INTO busanReply(no,cno,type,userid,username,sex,msg,group_id,group_step) "
			  +"VALUES((SELECT NVL(MAX(no)+1,1) FROM busanReply),"
			  +"#{cno},#{type},#{userid},#{username},"
			  +"#{sex},#{msg},#{group_id},"
			  +"#{group_step})")
	public void commentReplyReplyInsert(CommentVO vo);
	
	  
	  @Delete({
		    "<script>",
		    "DELETE FROM busanReply ",
		    "WHERE ",
		    "<choose>",
		        "<when test='group_step == 0'>",
		            "group_id = #{group_id}",
		        "</when>",
		        "<otherwise>",
		            "no = #{no}",
		        "</otherwise>",
		    "</choose>",
		    "</script>"
		})
		public void commentDelete(Map map);
}

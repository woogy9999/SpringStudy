package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

@Repository
public class CommentDAO {
	@Autowired
	private CommentMapper mapper;

	public List<CommentVO> commentListData(Map map){
		return mapper.commentListData(map);
	}

	public int commentTotalPage(int cno,int type) {
		return mapper.commentTotalPage(cno, type);
	}
	public void commentInsert(CommentVO vo) {
		mapper.commentInsert(vo);
	}

}

package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	@Select("select COUNT(*) FROM project_member "
			+ "WHERE id=#{id}")
	public int memberIdCount(String id);
	
	@Select("select pwd,id,name,sex FROM project_member "
			+ "WHERE id=#{id}")
	public MemberVO memberInfoData(String id);
}

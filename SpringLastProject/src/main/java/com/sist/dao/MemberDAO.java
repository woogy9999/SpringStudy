package com.sist.dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class MemberDAO {
  @Autowired
  private MemberMapper mapper;
  

  public MemberVO memberInfoData(String userid) {
	  return mapper.memberInfoData(userid);
  }

  
}
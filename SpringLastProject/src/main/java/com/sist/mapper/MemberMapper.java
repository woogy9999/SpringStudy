package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MemberMapper {

  @Select("SELECT * FROM projectMember "
  		+ "WHERE userid=#{userid}")
  public MemberVO memberInfoData(String userid);
}
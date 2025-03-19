package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;
public interface EmpMapper {
	
	@Select("SELECT empno,ename,job,sal,"
			+ "TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			+ "FROM emp")
	public List<EmpVO> empListData();
}

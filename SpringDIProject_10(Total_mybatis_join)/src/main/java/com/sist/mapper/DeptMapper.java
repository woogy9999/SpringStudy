package com.sist.mapper;
import java.util.*;


import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface DeptMapper {
	@Select("SELECT deptno,dname,loc FROm dept")
	public List<DeptVO> deptListData();
	

}

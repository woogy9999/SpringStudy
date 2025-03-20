package com.sist.dao;

import com.sist.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.sist.mapper.DeptMapper;
import com.sist.vo.*;

@Repository
public class DeptDAO {
	
	@Autowired
	private DeptMapper mapper;

	public List<DeptVO> deptListData() {
		return mapper.deptListData();
	}
}

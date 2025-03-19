package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 * 
 */

import com.sist.mapper.EmpMapper;
import com.sist.vo.EmpVO;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}

	public EmpVO empDetailData(int empno) {
		return mapper.empDetailData(empno);
	}
	
}

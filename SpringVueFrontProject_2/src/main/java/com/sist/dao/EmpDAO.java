package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Repository
public class EmpDAO {
	// 구현을 스프링에서 구현 => 구현된 메모리 주소값 받기
	// SpringVueFrontProject_1/pom.xml
	// SpringVueFrontProject_2/pom.xml
	@Autowired
	private EmpMapper mapper;
	
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	
    public List<DeptVO> deptListData(){
    	return mapper.deptListData();
    }
}

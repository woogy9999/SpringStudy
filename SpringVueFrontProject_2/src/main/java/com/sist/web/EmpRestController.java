package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.EmpDAO;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@RestController
public class EmpRestController {
	@Autowired
	private EmpDAO dao;
	
	@GetMapping(value="emp/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String emp_list_vue() throws Exception {
		List<EmpVO> eList=dao.empListData();
		List<DeptVO> dList=dao.deptListData();
		Map map=new HashMap();
		map.put("emp", eList);
		map.put("dept", dList);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}

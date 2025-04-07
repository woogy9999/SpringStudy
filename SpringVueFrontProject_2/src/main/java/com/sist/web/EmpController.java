package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.EmpDAO;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

// => 요청된 데이터를 JSP로 전송

/*
		순수하게 JSP => @Controller
		자바스크립트 => @RestController
		
 */
@Controller
public class EmpController {
	// Dao
	@Autowired
	private EmpDAO dao;

	@GetMapping("emp/list.do")
	public String emp_list(Model model) {

		// model => JSP로 데이터 전송 객체
		List<EmpVO> list = dao.empListData();
		
		model.addAttribute("list", list);
		return "emp/list";
	}

	@GetMapping("emp/list2.do")
	public String emp_list2() {

		return "emp/list2";
	}
	
}

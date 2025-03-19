package com.sist.main;

import org.openqa.selenium.devtools.v119.runtime.model.ExceptionRevoked;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		
		EmpDAO eDao=(EmpDAO)app.getBean("eDao");
		DeptDAO dDao=(DeptDAO)app.getBean("dDao");
		
		List<EmpVO> eList=eDao.empListData();
		List<DeptVO> dList=dDao.deptListData();
		
		System.out.println("=== 사원목록 ===");
		for(EmpVO vo:eList) {
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
		
		System.out.println("=== 부서정보 ===");
		for(DeptVO vo:dList) {
			System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
		}
		
	}
}

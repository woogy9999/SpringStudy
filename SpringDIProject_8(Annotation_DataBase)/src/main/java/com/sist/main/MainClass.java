package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        EmpDAO dao=(EmpDAO)app.getBean("empDAO");
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEname()+" "
        		+vo.getJob()+" "
        		+vo.getSal()+" "
        		+vo.getHiredate().toString());
        }
        
        Scanner scan=new Scanner(System.in);
        System.out.print("»ç¹ø:");
        int empno=scan.nextInt();
        EmpVO vo=dao.empDetailData(empno);
        System.out.println("ÀÌ¸§:"+vo.getEname());
        System.out.println("Á÷À§:"+vo.getJob());
        System.out.println("±Þ¿©:"+vo.getSal());
	}

}
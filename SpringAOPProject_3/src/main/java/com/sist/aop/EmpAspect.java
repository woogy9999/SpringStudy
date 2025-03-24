package com.sist.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * <aop:aspect ref="aspect">
			<aop:before method="before"
				pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))" />
			<aop:after method="after"
				pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))" />
			<aop:after-returning method="afterReturning"
				pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))" 
				returning="obj"
				/>
			<aop:after-throwing method="afterThrowing"
				pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))" 
				throwing="ex"/>
			<aop:around method="around"
				pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))" />
		</aop:aspect>
 */
import com.sist.dao.*;
@Aspect // �޸� �Ҵ��� �� �� ����
@Component
public class EmpAspect {
	@Autowired
	private EmpDAO dao;
	
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void before() {
		dao.getConnection();
	}
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void after() {
		dao.disConnection();
	}
	@Around("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		
		System.out.println("����ڰ� ȣ���� �޼ҵ�: "+jp.getSignature().getName());
		Object obj=null;
		long start=System.currentTimeMillis();
		obj=jp.proceed(); // invoke()
		
		long end=System.currentTimeMillis();
		System.out.println("���� �ð� Ȯ�� :"+(start-end));
		return obj;
		
	}
	@AfterThrowing(value = "execution(* com.sist.dao.EmpDAO.emp*(..))",throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("====== ���� �߻� ======");
		ex.printStackTrace();
	}

	@AfterReturning(value = "execution(* com.sist.dao.EmpDAO.emp*(..))",returning = "obj")
	public void afterReturning(Object obj) {
		System.out.println("=======����� �ڵ� ó��=======");
		// ���������� �ʿ��� request�� ���� => footer
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getDbday()+" "
					+vo.getJob()+" "
					+vo.getSal());
		}
	}
	
}

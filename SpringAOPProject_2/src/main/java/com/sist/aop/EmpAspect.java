package com.sist.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class EmpAspect {
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	// ������ ó��
	public void before() {
		dao.getConnection();
		System.out.println("Emp:getConnection");
	}
	
	public void after() {
		dao.disConnection();
		System.out.println("Emp:disConnection");
	}

	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;

		long start = System.currentTimeMillis();
		// ����ڰ� ��û�� �޼ҵ��� ���� �б� => ��
		// Ʈ����� => setAutoCommit(false)
		System.out.println("ȣ��� �޼ҵ�:" + jp.getSignature().getName());
		// �޼ҵ� ȣ��
		obj = jp.proceed(); // ������ �޼ҵ� ȣ�� => empListData

		long end = System.currentTimeMillis();
		System.out.println("����ð�:" + (end - start));
		// commit() ����
		return obj;
	}

	// catch ����� ó��
	public void afterThrowing(Throwable ex) {
		System.out.println("====== ���� �߻� ======");
		ex.printStackTrace();
	}

	// ���� ����ÿ� ó��
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

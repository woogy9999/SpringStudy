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
	// 진입전 처리
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
		// 사용자가 요청한 메소드의 정보 읽기 => 웹
		// 트랜잭션 => setAutoCommit(false)
		System.out.println("호출된 메소드:" + jp.getSignature().getName());
		// 메소드 호출
		obj = jp.proceed(); // 지정된 메소드 호출 => empListData

		long end = System.currentTimeMillis();
		System.out.println("수행시간:" + (end - start));
		// commit() 인증
		return obj;
	}

	// catch 수행시 처리
	public void afterThrowing(Throwable ex) {
		System.out.println("====== 에러 발생 ======");
		ex.printStackTrace();
	}

	// 정상 수행시에 처리
	public void afterReturning(Object obj) {
		System.out.println("=======결과값 자동 처리=======");
		// 공통적으로 필요한 request를 전송 => footer
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

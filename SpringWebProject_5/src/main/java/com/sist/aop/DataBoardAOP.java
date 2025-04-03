package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect		// 공통으로 사용하는게 모여져있다
@Component
public class DataBoardAOP {
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object obj=null;
		System.out.println("수행 메소드 : "+jp.getSignature().getName()); 
		// 사용자가 요청한 메소드 이름 출력
		long start=System.currentTimeMillis();
		obj=jp.proceed(); // 실제 호출된 메소드
		long end=System.currentTimeMillis();
		System.out.println("수행 시간 : "+(end-start));
		return obj;
	}
}

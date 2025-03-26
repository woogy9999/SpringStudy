package com.sist.aop;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/*
 * 
 * 
 * 
 * 			pointcut joincut
 * 
 * 			PointCut
 			execution("* 패키지명.클래스.메소드(..)")
 					   |					|
 					   리턴형				  매개변수 (0개 이상) 없을 수도 있음
 					   
 			within("패키지") => 지정된 패키지에 있는 모든 클래스 적용
 			
 			=> Advice(JoinPoint +PointCut)
 				----------------------------여러개 Aspect
 			
 * 
 */
@Aspect
@Component
public class ControllerAspect {
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("호출 메소드 : " + jp.getSignature().getName());
		obj=jp.proceed();
		long end=System.currentTimeMillis();
		System.out.println("수행 시간 : "+(end-start));
		return obj;
	}
	
	@AfterReturning(value = "execution(* com.sist.web.*Controller.*(..))" ,returning = "obj" )
	public void afterReturning(Object obj) {
		if(obj!=null)
		{
			String path=(String)obj;
			System.out.println("호출된 JSP : "+path);
		}
	}
	// => ControllerAdvice : Controller예외처리를 공통으로 처리
	
}

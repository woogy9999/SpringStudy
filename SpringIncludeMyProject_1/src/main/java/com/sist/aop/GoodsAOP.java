package com.sist.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Aspect
@Component
public class GoodsAOP {
	
	@Autowired
	private GoodsDAO dao;
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void after() {
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<GoodsVO> gList=dao.goodsAsideData();
		request.setAttribute("gList", gList);
	}
	
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		Object obj=null;
		System.out.println("사용자 요청:"+jp.getSignature().getName());
		obj=jp.proceed();
		System.out.println("요청 처리 완료");
		return obj;
	}
}

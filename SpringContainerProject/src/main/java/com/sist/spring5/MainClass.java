package com.sist.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
  
  	스프링에서 XMl을 읽어서
  		1) 메모리 할당
  		2) Map에 저장
  		3) 대기
  		4) 객체 소멸
  		
  		컨테이너 => 객체의 생명 주기 관리
 
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		Sawon sa=(Sawon)app.getBean("sawon");
		sa.display();
		
		Member member=(Member)app.getBean("member");
		member.display();
		
		Student student=(Student)app.getBean("std");
		student.display();
	}
}

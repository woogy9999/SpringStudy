package com.sist.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
  
  	���������� XMl�� �о
  		1) �޸� �Ҵ�
  		2) Map�� ����
  		3) ���
  		4) ��ü �Ҹ�
  		
  		�����̳� => ��ü�� ���� �ֱ� ����
 
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

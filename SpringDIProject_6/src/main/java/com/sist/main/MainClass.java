package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.member.Member;
import com.sist.sawon.Sawon;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		Member m=(Member)app.getBean("mem");
		m.display();
		
	}
}

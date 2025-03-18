package com.sist.spring1;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.google.protobuf.Struct;

public class MainClass {
	public static void main(String[] args) {
		//ApplicationContext app=new ClassPathXmlApplicationContext("app3.xml");
		GenericApplicationContext app=new GenericXmlApplicationContext("app3.xml");
		Student std=(Student)app.getBean("std");
		
		System.out.println("�й�:"+std.getHakbun());
		System.out.println("�̸�:"+std.getHuman().getName());
		System.out.println("����:"+std.getHuman().getSex());
		System.out.println("�ּ�:"+std.getHuman().getAddress());
		app.close();// System.gc()
	}
}

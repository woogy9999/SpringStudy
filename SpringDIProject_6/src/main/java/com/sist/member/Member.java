package com.sist.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.sawon.*;

@Component("mem")
//@Target(value={TYPE})

/*
 * 
 		������̼� => ������
 		type => Ŭ���� ����
 		class A
 		{
 			// ���� ���� => FIELD
 			B b;
 			public A(){} => CONSTRUCTOR
 			
 			public void setB(B b){} => METHOD
 							----- PARAMETER
 		}
 */
public class Member {

	@Autowired
	/*
			@Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
	 */
	private Sawon sawon; // sawon�� ��ü�� ã�Ƽ� �ּҰ��� ����
	
	
	public void setSawon(Sawon sawon) {
		this.sawon = sawon;
	}


	public void display()
	{
			System.out.println("sawon �ּ�:"+sawon);
		System.out.println("���:"+sawon.getSabun());
		System.out.println("�̸�:"+sawon.getName());
		
	}
}

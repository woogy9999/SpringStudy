package com.sist.spring1;

/*
 *		HelloMain�� hello�� �����Ѵ� => ���ռ��� ���� ���α׷�
  									------------------
  									| ���������� ��ƴ�
  									| �����ÿ� �ٸ� Ŭ������ ������ ���� ��� 
  		
  		
  		�������̸� => new�� ������� �ʴ´�
  					----- ���ռ��� ���� ���α׷�
  
  
 */


public class HelloMain {
	public static void main(String[] args) {
		Hello hello=new Hello();
		String msg=hello.seyHello("ȫ�浿");
		System.out.println(msg);
	}
}

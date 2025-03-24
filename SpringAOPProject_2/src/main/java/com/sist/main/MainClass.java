package com.sist.main;

// Proxy => �븮�� => AOP

/*
  		���α׷� => �ٽ� �ڵ�
  			     ---------
  			     �ΰ����� �ڵ� => ��Ƽ� ���� => ������ / AOP
  			      | �����ͺ��̽� ���� / �����ͺ��̽� ����
  			      | ���� (�ΰ� => ����)
  			      | Ʈ����� => commit / rollback
  			      | �α�
  			      | ���� �����
  			      ------------------------------- AOP ���̺귯��
  			      | ����� ���� AOP(�ѵι�)
  			      ---------------- ���ͼ�Ʈ (�ڵ� �α���) ,AOP
  		
  		�ߺ� ���� => �޼ҵ�ȭ ó��
  		---------------------- CallBack
  		AOP�� ����
  		1. Aspect : �������� ����Ǵ� ����� ��Ƶ� ��� => ���� ���
  		2. Target : �����ϴ� �� => ����ִ� ����
  		3. Advice : ��� � ����� �߰��� ��
  		4. JoinPoint : ���� => ��� ȣ��
  					  Befor
  					  After
  					  After-Returning
  					  After-Throwing
  					  Around
  					  
  					  public void display()
  					  {
  					  }
  		5. PointCut
 
 */
public class MainClass {
		
	public static void main(String[] args) {
		My m=new My();
		m.execute();
		MyTarget mt=new MyTarget(m);
		mt.execute();
		
	}
}

package com.sist.main;

public class MyTarget {
	private My my;
	public MyTarget(My my) {
		this.my=my;
	}
	public void execute() {
		
		// Target�� ��Ƽ� ó�� => ����(�����ٴ��� �޼ҵ带 ��Ƽ� ó��)
		System.out.println("my������");
		my.execute();
		System.out.println("my������");
	}
}

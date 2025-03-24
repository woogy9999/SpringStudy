package com.sist.main;

public class MyTarget {
	private My my;
	public MyTarget(My my) {
		this.my=my;
	}
	public void execute() {
		
		// Target을 모아서 처리 => 위빙(공통기바느이 메소드를 모아서 처리)
		System.out.println("my수행전");
		my.execute();
		System.out.println("my수행후");
	}
}

package com.sist.main;

public class Sawon {
	
	
	private int sabun;
	private String name;
	private String dept;
	private String loc;
	private int pay;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public Sawon(int sabun, String name, String dept, String loc, int pay) {
	    this.sabun = sabun;
	    this.name = name;
	    this.dept = dept;
	    this.loc = loc;
	    this.pay = pay;
	}
	public void print() {
	    System.out.println("���: " + sabun);
	    System.out.println("�̸�: " + name);
	    System.out.println("�μ�: " + dept);
	    System.out.println("�ٹ���: " + loc);
	    System.out.println("�޿�: " + pay);
	    System.out.println("===============================");
	}
	
	
}

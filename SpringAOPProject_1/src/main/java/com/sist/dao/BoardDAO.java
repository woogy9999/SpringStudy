package com.sist.dao;
/*
 * 	���ռ��� ���� ���α׷� => �������� �����ڰ� ���� ����
 *  ------------------ Container / POJO / DI
 *  					| Ŭ������ ������ ��Ƽ� ����
 * 
 */
public class BoardDAO {
	public void getConnection()
	{
		System.out.println("����Ŭ ����!!");
	}
	public void disConnection()
	{
		System.out.println("����Ŭ �ݱ�!!");
	}
	public void boardListData(int page) {
		//getConnection();
		System.out.println(page+"������ ��� ���");
		//disConnection();
	}
	public String boardDetailData(String name) {
		
		//	getConnection();
		System.out.println(name+"�� ���� �󼼺���");
		//disConnection();
		return name;
	}
	public void boardInsert() {
		//getConnection();
		System.out.println("�Խù� �߰� �Ϸ�");
		//disConnection();
	}
	
	public void boardUpdate() {
		//getConnection();
		System.out.println("�Խù� ���� �Ϸ�");
		//disConnection();
	}
	
	public void boardDelete() {
		//getConnection();
		System.out.println("�Խù� ���� �Ϸ�");
		//disConnection();
	}
	public void print() {
		System.out.println("���α׷� ����");
	}
}

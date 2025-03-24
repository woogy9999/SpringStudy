package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class EmpDAO {
	private MyDataSource ds;
	private Connection conn;
	private PreparedStatement ps;

	/*
	 * <bean id="dao" class="com.sist.dao.EmpDAO" 
	 * c:ds-ref="ds" />
	
	 */
	
	@Autowired
	public EmpDAO(MyDataSource ds) {
		this.ds = ds;
		try {
			Class.forName(ds.getDriver());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getConnection() {
		try {
			
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUsername(),ds.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// ��� ����
	// => ��� ��� => Around => ȣ��� �޼ҵ� / ���� �ð�
	public List<EmpVO> empListData(){
		
		List<EmpVO> list=new ArrayList<EmpVO>();
		// before => getConnettion
		try {
			String sql="SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') "
					+ "FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EmpVO vo =new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setSal(rs.getInt(4));
				vo.setDbday(rs.getString(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	// => �󼼺��� => Around
	public EmpVO empDetailData(int empno) {
		 EmpVO vo=new EmpVO();
		 // getConnection => before
		 try {
				String sql="SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') "
						+ "FROM emp "
						+ "WHERE empno="+empno;
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				rs.next();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setSal(rs.getInt(4));
				vo.setDbday(rs.getString(5));
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		 // disConnection => after
	
		 return vo;
	}
	// => ������ ó�� / ���� ó�� /
}

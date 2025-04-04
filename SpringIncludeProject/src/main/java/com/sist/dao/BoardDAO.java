package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

@Repository
//@Scope("prototype")
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	public BoardDAO() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection() {
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<BoardVO> boardListData(int page){
		List<BoardVO> list=new ArrayList<BoardVO>();
		
		try {
			getConnection();
			String sql="SELECT no,subject,name,hit,regdate,group_teb,num "
					+ "FROM (SELECT no,subject,name,hit,regdate,group_teb,rownum as num "
					+ "FROM (SELECT no,subject,name,hit,regdate,group_teb "
					+ "FROM springReplyBoard ORDER BY group_id DESC,group_step ASC))"
					+ "WHERE num BETWEEN ? AND ?";
			
			ps=conn.prepareStatement(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=(rowSize*page);
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setRegdate(rs.getDate(5));
				vo.setGroup_teb(rs.getInt(6));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		
		return list;
	}
	// 총페이지
	public int boardRowCount() {
		
		int total=0;
		try {
			getConnection();
			String sql="SELECT COUNT(*) FROM springReplyBoard";
			ps=conn.prepareStatement(sql);
			
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            total = rs.getInt(1); 
	        }
	        rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return total;
	}
	
	public void boardInsert(BoardVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO springReplyBoard("
					+ "no,name,subject,content,pwd,group_id) "
					+ "VALUES(srb_no_seq.nextval,?,?,?,?,"
					+ "(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject()); 
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
	}
	
	public BoardVO boardDetailData(int no) {
		BoardVO vo=new BoardVO();
		try {
			getConnection();
			
			// around start
			conn.setAutoCommit(false);
			String sql="UPDATE springReplyBoard SET "
					+ "hit=hit+1 "
					+ "WHERE no="+no;
			
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

			
			sql = "SELECT no, name, subject, content,hit,regdate "
				 + "FROM springReplyBoard WHERE no="+no;
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setRegdate(rs.getDate(6));
				
			}
			rs.close();
			// around end
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			disConnection();
		}
		return vo;
	}
	
	public BoardVO boardUpdateData(int no) {
		BoardVO vo=new BoardVO();
		try {
			getConnection();
			
			String sql = "SELECT no, name, subject, content,hit,regdate "
				 + "FROM springReplyBoard WHERE no="+no;
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setRegdate(rs.getDate(6));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
	// 수정하기 
	public boolean boardUpdate(BoardVO vo) {
		
		boolean bCheck=false;
		try {
			getConnection();
			String sql="SELECT pwd FROM springReplyBoard "
					+ "WHERE no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd())) {
				bCheck=true;
				sql="UPDATE springReplyBoard SET "
						+ "name=?,subject=?,content=? "
						+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				//?에 값을 채운다
				
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				
				ps.executeUpdate();
				
			}else {
				bCheck=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		
		return bCheck;
		
	}
	/*
				   고유번호
				   	  그룹 
				   	  	 그룹에서 출력순서
				   	  	 		레벨 
				   	  	 		  상위게시물번호
				   	  	 			    	답변갯수
				// no  gi  gs  gt root depth
			AA	   1	1	0	0	0	2
			 -D	   5	1	1	1	1	0
			 -B	   3	1	2	1	1	1
			  -C   4	1	3	2	3	0
			E	   2	2	0	0	0	0
	 		
	 */
	// reply / delete => 트랜잭션
	public void replyInsert(int pno,BoardVO vo) {
		
		try {
			getConnection();
			conn.setAutoCommit(false);
			// SQL 문장 여러개 있는 경우.
			// 상위 게시물 id step tab 
			String sql="SELECT group_id,group_step,group_teb "
					+ "FROM springReplyBoard "
					+ "WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int gi=rs.getInt(1); // insert할때 그대로
			int gs=rs.getInt(2); // +1
			int gt=rs.getInt(3); // +1
			rs.close();
			
			// => group_step을 증가 (그룹별 출력 순서 변경) 
			sql="UPDATE springReplyBoard SET "
					+ "group_step=group_step+1 "
					+ "WHERE group_id=? AND group_step>?";

			ps=conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gt);
			ps.executeUpdate();
			
			//=>insert
			sql="INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id,group_step,group_teb,root)"
				+ "VALUES(srb_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			 ps = conn.prepareStatement(sql);
		     ps.setString(1, vo.getName());
		     ps.setString(2, vo.getSubject());
		     ps.setString(3, vo.getContent());
		     ps.setString(4, vo.getPwd());
		     ps.setInt(5, gi);       // 부모 group_id
		     ps.setInt(6, gs + 1);   // 부모 group_step + 1
		     ps.setInt(7, gt + 1);   // 부모 group_tab + 1
		     ps.setInt(8, pno);      // 부모 글 번호 root로 설정
		     ps.executeUpdate();
			
		     //=>depth++
		     sql = "UPDATE springReplyBoard SET depth = depth + 1 WHERE no ="+pno;
		     ps = conn.prepareStatement(sql);
		     ps.executeUpdate();
		        
		        
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			disConnection();
		}
		
	}
	
	//삭제하기
	public boolean boardDelete(int no,String pwd) {
		boolean bCheck=false;
			try {
				getConnection();
				conn.setAutoCommit(false);
				
				// ㅂ밀번호 확인
				String sql="SELECT root,depth,pwd "
							+ "FROM springReplyBoard "
							+ "WHERE no="+no;
			        ps = conn.prepareStatement(sql);
			        ResultSet rs = ps.executeQuery();
			        rs.next();
			        int root=rs.getInt(1);
			        int depth=rs.getInt(2);
			        String db_pwd=rs.getString(3);
			        if(db_pwd.equals(pwd)) {
			        	bCheck=true;
			        	if(depth==0) {
			        		sql = "DELETE FROM springReplyBoard WHERE no="+no;
			                ps = conn.prepareStatement(sql);
			                ps.executeUpdate();
			        	}else {
			        		String msg="관리자가 섹제한 게시물입니다";
			        		sql="UPDATE springReplyBoard SET "
			        				+ "subject=?,content=? "
			        				+ "WHERE no=?";
			        		ps = conn.prepareStatement(sql);
			        		ps.setString(1, msg);
			        		ps.setString(2, msg);
			        		ps.setInt(3, no);
			                ps.executeUpdate();
			        	}
			        	sql="UPDATE springReplyBoard SET "
			        			+ "depth=depth-1 "
			        			+ "WHERE no="+root;
			        	ps = conn.prepareStatement(sql);
			        	ps.executeUpdate();
			        }
			         // 댓글이 있는 경우는 삭제 대신 내용만 수정하는 방식도 고려 가능
			                
			        rs.close();
				
				conn.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
				try {
					conn.rollback();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}finally {
				try {
					conn.setAutoCommit(true);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				disConnection();
			}
			
			return bCheck;
	}
}

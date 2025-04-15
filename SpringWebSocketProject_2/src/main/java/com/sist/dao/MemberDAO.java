package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.MemberVO;
@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	/*
	 * @Select("select COUNT(*) FROM project_member "
			+ "WHERE id=#{id}")
	public int memberIdCount(String id);
	
	@Select("select pwd,id,name,sex FROM project_member "
			+ "WHERE id=#{id}")
	public MemberVO memberInfoData(String id);
	 */
	
	public MemberVO memberLogin(String id,String pwd) {
		MemberVO vo=new MemberVO();
		int count=mapper.memberIdCount(id);
		if(count==0)
		{
			vo.setMsg("NOID");
			System.out.println("nono");
			
		}else {
			MemberVO dbvo=mapper.memberInfoData(id);
			if(pwd.equals(dbvo.getPwd()))
			{
				vo.setMsg("OK");
				vo.setId(dbvo.getId());
				vo.setPwd(dbvo.getName());
				vo.setSex(dbvo.getSex());
				// 로그인시에 세션에 저장할 데이터 
				System.out.println("asdasd");
			}else {
				vo.setMsg("NOPWD");
				System.out.println("qqqq");
			}
		}
		
		return vo;
	}
}

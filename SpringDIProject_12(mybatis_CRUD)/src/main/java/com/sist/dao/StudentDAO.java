package com.sist.dao;
//XML ���

import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;

// Annotation=> �ڵ�����
// XML => �����ڱ���
public class StudentDAO extends SqlSessionDaoSupport{
	
	public List<StudentVO> studentListData(){
		return getSqlSession().selectList("studentListData");
	}

	public StudentVO studentDetailData(int hakbun) {
		return getSqlSession().selectOne("studentDetailData",hakbun);
	}
	public void studentInsert(StudentVO vo) {
		getSqlSession().insert("studentInsert",vo);
	}
	public void studentDelete(int hakbun) {
		getSqlSession().insert("studentDelete",hakbun);
	}
	public void studentUpdate(StudentVO vo) {
		getSqlSession().insert("studentUpdate",vo);
	}
}

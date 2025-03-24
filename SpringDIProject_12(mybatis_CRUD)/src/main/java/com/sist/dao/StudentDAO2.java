package com.sist.dao;
//Annotation ±â¹Ý
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
import com.sist.mapper.*;
public class StudentDAO2 {
	private StudentMapper1 mapper;

	public void setMapper(StudentMapper1 mapper) {
		this.mapper = mapper;
	}
	
	public List<StudentVO> studentListData(){
		return mapper.studentListData();
	}

	public StudentVO studentDetailData(int hakbun) {
		return mapper.studentDetailData(hakbun);
	}
	public void studentInsert(StudentVO vo){
		mapper.studentInsert(vo);
		
	}
	public void studentDelete(int hakbun){
		mapper.studentDelete(hakbun);	
	}
	public void studentUpdate(StudentVO vo){
		mapper.studentUpdate(vo);
	}
}

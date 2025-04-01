package com.sist.vo;
/*
 * 
 * 
 * NO        NOT NULL NUMBER         
NAME      NOT NULL VARCHAR2(52)   
SUBJECT   NOT NULL VARCHAR2(4000) 
CONTENT   NOT NULL CLOB           
PWD       NOT NULL VARCHAR2(10)   
REGDATE            DATE           
HIT                NUMBER         
FILECOUNT          NUMBER  
 */

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DataBoardVO {

	// => <input type=file name="files[0]">
	private int no,hit,filecount;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
	private List<MultipartFile> files=new ArrayList<MultipartFile>();
}

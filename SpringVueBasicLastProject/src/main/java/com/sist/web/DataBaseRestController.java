package com.sist.web;
// yml 
// => vue / React => Spring-Boot

import org.apache.commons.collections.map.HashedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;

@RestController
public class DataBaseRestController {
	@Autowired
	private DataBoardDAO dao;
	
	@GetMapping(value="databoard/list_vue.do")
	public Map databoardListData(int page){
		Map map=new HashMap();
		map.put("start", (page*10)-9);
		map.put("end", page*10);
		
		List<DataBoardVO> list=dao.databoardListData(map);
		int totalpage=dao.databoardTotalPage();
		
		// JSP로 값을 전송
		map=new HashedMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
				
		//ObjectMapper mapper=new ObjectMapper();
		//String json=mapper.writeValueAsString(map);
		return map;
	}
	@PostMapping(value="databoard/insert_ok.do",produces = "text/plain;charset=UTF-8")
	public String databoardInsertOk(DataBoardVO vo,HttpServletRequest request)
	{
		String path="C:\\upload";
		//path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
		String result="";
		try {
			List<MultipartFile> list=vo.getFiles();
			if(list==null)
			{
				// 파일이 없는 경우
				vo.setFilename("");
				vo.setFilesize("");
				vo.setFilecount(0);
			}
			else
			{
				// 파일이 있는 경우
				String filename="";
				String filesize="";
				for(MultipartFile mf:list)
				{
					String name=mf.getOriginalFilename();
					File file=new File(path+"\\"+name);
					mf.transferTo(file); // 업로드
					filename+=name+",";
					filesize+=file.length()+",";
				}
				filename=filename.substring(0,filename.lastIndexOf(","));
				filesize=filesize.substring(0,filesize.lastIndexOf(","));
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(list.size());
			}
			result="yes";
			dao.databoardInsert(vo);
		} catch (Exception e) {
			result=e.getMessage();
		}
		return result;
	}
	
	@GetMapping(value="databoard/detail_vue.do")
	public DataBoardVO databoard_Detail(int no){
		
		DataBoardVO vo=dao.databoardDetailData(no); 
		
		return vo;
	}
	
	@GetMapping(value="databoard/download.do")
	public void databoard_download(String fn,HttpServletResponse response) {
		 try {
			 
		        String path="C:\\upload";
		        File file = new File(path+"\\" + fn);
		        
		        response.setContentLength((int) file.length());
		        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fn, "UTF-8"));
		        response.setContentType("application/octet-stream");

		        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		        
		        
		        int i=0;
		        byte[] buffer = new byte[1024];
		        while ((i = bis.read(buffer)) != -1) {
		            bos.write(buffer, 0, i);
		        }

		        bis.close();
		        bos.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	

}

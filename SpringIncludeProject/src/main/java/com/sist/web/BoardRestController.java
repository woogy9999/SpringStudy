package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

// update_ok jsp만들지 말고
// 자바스크립트 연동해서 동작. 서비스는 안씀
@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao; // 스프링에서 객체 관리

	@PostMapping(value="replyboard/update_ok.do",produces = "text/html;charset=UTF-8")
	public String board_update_ok(BoardVO vo) {
		
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true) {
			
			result="<script>location.href=\"../replyboard/detail.do?no="+vo.getNo()+"\";</script>";
		}else {
			result="<script>"
					+ "alert(\"비밀번호가 틀립니다\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return result;
	}
	 @PostMapping(value="replyboard/delete_ok.do",produces = "text/html;charset=UTF-8")
	   public String board_delete(int no,String pwd)
	   {
		   String result="";
		   boolean bCheck=dao.boardDelete(no, pwd);
		   if(bCheck==true)
		   {
			  result="<script>location.href=\"../replyboard/list.do\";</script>";   
		   }
		   else
		   {
			   result="<script>"
					 +"alert(\"비밀번호가 틀립니다\");"
					 +"history.back();"
					 +"</script>";
		   }
		   return result;
	   }
	
	

}

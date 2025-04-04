<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3 class="text-center">글쓰기</h3>
   <form method="post" action="insert_ok.do">
   <table class="table">
     <tr>
      <th width=15%>이름</th>
      <td width=85%>
       <input type=text name=name size=20 required
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>제목</th>
      <td width=85%>
       <input type=text name=subject size=50 required
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>내용</th>
      <td width=85%>
       <textarea rows="5" cols="52" name=content required></textarea>
      </td>
     </tr>
     <tr>
      <th width=15%>비밀번호</th>
      <td width=85%>
       <input type=password name=pwd size=10 required
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
       <td colspan="2" align=center>
         <input type=submit value="글쓰기" class="btn btn-xs btn-danger">
         <input type=button value="취소" class="btn btn-xs btn-success" 
          onclick="javascript:history.back()"
         >
       </td>
     </tr>
   </table>
   </form>
</body>
</html>
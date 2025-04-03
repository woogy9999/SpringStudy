<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<tr>
			<td class="text-center" colspan="3">
			<img src="${vo.poster }" style="width: 700px; height: 300px"></td>
		</tr>
		<tr>
		 <td class="text-center" colspan="3">${vo.title }</td>
		</tr>
		<tr>
		 <td class="text-center" style="color:gray;" colspan="3">${vo.content }</td>
		</tr>
		<tr>
			<td class="text-center"><img src="../recipe/icon/a1.png"></td>
			<td class="text-center"><img src="../recipe/icon/a2.png"></td>
			<td class="text-center"><img src="../recipe/icon/a3.png"></td>
		</tr>
		<tr>
			<td class="text-center">${vo.info1 }</td>
			<td class="text-center">${vo.info2 }</td>
			<td class="text-center">${vo.info3 }</td>
		</tr>
		<tr>
			<td class="text-center"></td> 
			<td class="text-center"></td>
			<td class="text-center"></td>
		</tr>
	</table>
	<table class="table">
		<tr>
		 <td><h3>[재료]</h3></td>
		</tr>
		<tr>
		 <td>
			<ul>
				<c:forTokens items="${vo.data }" delims="," var="d">
					<li>${d }</li>
				</c:forTokens>
			</ul>
		</td>
		</tr>
	</table>
	<table class="table">
		<tr>
		 <td><h3>[조리순서]</h3></td>
		</tr>
		
		<tr>
		 <td>
		 	<c:forEach var="str" items="${mList }" varStatus="s">
		 	 <table class="table">
		 	 	<tr>
				 <td width=75%>${str }</td>
				 <td width=25%>
				 	<img src="${iList[s.index]}" style="width: 120px;height: 60px;">
				 </td>
				</tr>
		 	 </table>
		 	</c:forEach>
		</td>
		</tr>
	</table>
	<table class="table">
    <tr>
        <td colspan="2"><h3>레시피 작성자</h3></td>
    </tr>
    <tr>
        <td width="20%" rowspan="2">
            <img src="${vo.chef_poster }" style="width: 100px; height: 100px;" class="img-circle">
        </td>
        <td width="80%">
            <p>${vo.chef }</p>
        </td>
        <td width="20%" rowspan="2"></td>
        <td width="80%">
            <p>${vo.chef_profile }</p>
        </td>
    </tr>
</table>
	
</body>
</html>






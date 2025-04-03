<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	width: 15ch;
}
</style>

</head>

<body>
	<table class="table">
		<tr>
		 <td class="text-center"><h3>상품 순위</h3></td>
		</tr>
	</table>
	<table class="table">
		<tr>
		 <th class="text-center">순위</th>
		 <th class="text-center"></th>
		 <th class="text-center">상품명</th>
		</tr>
		<c:forEach var="gvo" items="${gList }">
			<tr>
			 <td class="text-center">${gvo.no }</td>
			 <td class="text-center">
			 	<img src="${gvo.goods_poster}" style="width:30px;height: 30px;">
			 </td>
			 <td class="text-center"><p>${gvo.goods_name }</p></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
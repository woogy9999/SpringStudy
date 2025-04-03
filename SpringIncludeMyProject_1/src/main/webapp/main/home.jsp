<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
}
</style>
</head>
<body>
	<c:forEach var="vo" items="${list }">
		<div class="col-md-3">
			<div class="thumbnail">
				<a href="../goods/detail.do?no=${vo.no}"> 
				<img src="${vo.goods_poster }" title="${vo.goods_name }" style="width: 180px; height: 150px;">
					<div class="caption">
						<p>${vo.goods_name }</p>
					</div>
				</a>
			</div>
		</div>
	</c:forEach>
	<div style="height: 10px"></div>
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${startPage>1 }">
			<li><a href="../main/main.do?page=${startPage-1 }">&lt;</a></li>
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<li ${i==curpage?"class=active":"" }><a href="../main/main.do?page=${i }">${i }</a></li>
			</c:forEach>
			
			<c:if test="${endPage<totalpage }">
			<li><a href="../main/main.do?page=${endPage+1 }">&gt;</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
	@Controller : JSTL / EL
	@RestController : JSON = Vue=Ajax


 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="breadcumb-nav">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<table class="table">
						<tr>
						 <th class="text-center">번호</th>
						 <th class="text-center"></th>
						 <th class="text-center">업체명</th>
						 <th class="text-center">예약일</th>
						 <th class="text-center">시간</th>
						 <th class="text-center">인원</th>
						 <th class="text-center">등록일</th>
						 <th class="text-center">비고</th>
						</tr>	
						<c:forEach var="vo" items="${list }">
							<tr>
							 <td class="text-center">${vo.rno}</td>
							 <td class="text-center">
							   <img src="https://www.menupan.com${vo.fvo.poster }"
							    style="width: 35px; height: 35px;">
							 </td>
							 <td>${vo.fvo.name }</td>
							 <td class="text-center">${vo.rday }</td>
							 <td class="text-center">${vo.rtime }</td>
							 <td class="text-center">${vo.rinwon }</td>
							 <td class="text-center">${vo.dbday }</td>
							 <td class="text-center">
							   <input type="button" class="btn-sm btn-success" value="${vo.isReserve==0?'예약대기':'예약완료'}" >
							   <a href="../reserve/reserve_delete.do?rno=${vo.rno }" class="btn-sm btn-info">취소</a>
							 </td>
							</tr> 
						</c:forEach>				
					</table>
				</div>
			</div>
		</div>
	</div>

	<section class="single_blog_area section_padding_80" id="reserveApp">
		<div class="container">
			<div class="row justify-content-center ">
				<div class="col-12 col-lg-12">
					<div class="row no-gutters">
						<table class="table">
						  <tr> 
						   <td>
						   
						   </td>
						  </tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
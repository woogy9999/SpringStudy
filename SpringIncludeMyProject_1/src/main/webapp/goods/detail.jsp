<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
</style>
</head>
<body>
<div style="margin-left: 50px;">
	<table class="table">
	   <tr>
		   <td width="30%" align="center" rowspan="9">
			   <img src="${vo.goods_poster}"   id="image" style="width:380px; height: 300px;" class="img-rounded"  >
		   </td>
		   <td width="70%" class="tdcenter">
			   <span id="title">
				  ${vo.goods_name}
			   </span>
		   </td>
	   </tr>
	   <tr>
		   <td width="70%">
			   <span id="sub">${vo.goods_sub}</span>
		   </td>
	   </tr>
	   <tr>
		   <td width="70%">
			   <span id="percent">${vo.goods_discount}%</span>&nbsp;
			   <span id="price" data-value="${vo.price}">${vo.goods_price}</span>
			   <!--  데이터를 저장할때 속성은 사용자 정의로 가능하다 -->
			   <p>
				   <del id="psub">${vo.goods_first_price }</del>
			   </p>
		   </td>
	   </tr>
	   <tr>
		   <td width="70%">
			   <span id="star">★★★★★</span>
			   <span id="blod">4.8</span>
			   <span id="count">(5)</span>
		   </td>
	   </tr>
	   <tr>
		   <td width="70%">
			   <img src="https://recipe1.ezmember.co.kr/img/mobile/icon_delivery3.png" width="20" height="20">
			   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   <span id="del">${vo.goods_delivery}</span>
		   </td>
	   </tr>
	   <tr>
		   <td width="70%">
			   <img src="https://recipe1.ezmember.co.kr/img/mobile/icon_point.png" width="20" height="20">
			   적립&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   <span id="del">1,595원</span> 적립 (모든 회원 구매액의 0.5% 적립)</span>
		   </td>
	   </tr>
	   <tr>
	     <td width="70%" class="text-right">
	       총금액:<span id="total">${vo.goods_price}</span>
	     </td>
	   </tr>
	   <tr>
		   <td width="70%">
		        <input type="button" value="장바구니" id="cart" style="float: left">
			   <input type="button" value="바로구매" id="buy" style="float: left">
			   <input type="button" value="목록" onclick="javascript:history.back()" id="list">
		   </td>
	   </tr>
   </table>
   </div>
</body>
</html>
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
.container {
	margin-top: 50px;
}

.row {
	width: 960px;
	margin: 0px auto;
}
</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['단어', '횟수'],
          ['커피',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var options = {
          title: '맛집 소개 정보',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div class="container">
		<div class="row">
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
	 <%--   <tr>
		   <td width="70%">
			   <select id="sel" data-price="${vo.price }">
				   <option>수량선택</option>
				   <c:forEach var="i" begin="1" end="10">
				    <option>${i }</option>
				   </c:forEach>
			   </select>
		   </td>
	   </tr> --%>
	   <tr>
	     <td width="70%" class="text-right">
	       총금액:<span id="total">${vo.price}원</span>
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
			<div style="height: 20px;"></div>
			<table class="table">
				<tr>
				 <td>
				 <!-- 그래프 출력 위치임 -->
				  <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
				 </td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
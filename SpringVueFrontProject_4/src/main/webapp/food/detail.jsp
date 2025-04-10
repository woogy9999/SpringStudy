<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Insert title here</title>

<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 800px;
}

p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td width=40% class="text-center" rowspan="8">
						<img :src="'https://www.menupan.com'+food_vo.poster" style="width:380px; height: 300px;" class="img-rounded">
						
					</td>
					<td width=60% colspan="2">
						<h3>{{food_vo.name }}&nbsp;<span style="color:orange;">{{food_vo.score }}</span></h3>
					</td>
				</tr>
				
				<tr>
				 <td width=15% style="color: gray;">음식종류</td>
				 <td width=45%>{{food_vo.type }}</td>
				</tr>
				
				<tr>
				 <td width=15% style="color: gray;">주소</td>
				 <td width=45%>{{food_vo.address }}</td>
				</tr>
				
				<tr>
				 <td width=15% style="color: gray;">전화</td>
				 <td width=45%>{{food_vo.phone }}</td>
				</tr>
				
				<tr>
				 <td width=15% style="color: gray;">가격대</td>
				 <td width=45%>{{food_vo.price }}</td>
				</tr>
				
				<tr>
				 <td width=15% style="color: gray;">주차</td>
				 <td width=45%>{{food_vo.parking }}</td>
				</tr>
				
				<tr>
				 <td width=15% style="color: gray;">영업시간</td>
				 <td width=45%>{{food_vo.time }}</td>
				</tr>
				
				<tr>
				 <td width=15% style="color: gray;">테마</td>
				 <td width=45%>{{food_vo.theme }}</td>
				</tr>
				
			</table>
			<table class="table">
				<tr>
					<td>{{food_vo.content }}</td>
				</tr>
			</table>
			<div style="height: 20px;"></div>
			<table class="table" style="text-align: right;">
				<tr>
				 <td>
				  <input type="button" class="btn-sm btn-danger" onclick="javascript:history.back()" value="목록">
				 </td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let detailApp=Vue.createApp({
			data(){
				return{
					fno:${param.fno},
					food_vo:{}
				}	
			},
			mounted(){
				axios.get('../food/detail_vue.do',{
					params:{
						fno:this.fno
					}
				})
				.then(res=>{
					console.log(res.data)
					this.food_vo=res.data.vo
				})
				.catch(error=>{
					console.log(error.response)	
				})
			},
			methods:{
				
			}
		}).mount(".container")
	</script>
</body>
</html>
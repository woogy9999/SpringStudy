<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

h3 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">사원 목록</h3>
			<table class="table">
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>입사일</th>
					<th>직위</th>
					<th>급여</th>
				</tr>
				<tr v-for="vo in ld.emp">
					<td>{{vo.empno}}</td>
					<td>{{vo.ename}}</td>
					<td>{{vo.dbday}}</td>
					<td>{{vo.job}}</td>
					<td>{{vo.sal}}</td>
				</tr>
			</table>
		</div>

		<div class="row">
			<h3>부서 정보</h3>
			<table class="table">
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
					<th>근무지</th>
				</tr>
				<tr v-for="vo in ld.dept">
					<th>{{vo.deptno}}</th>
					<th>{{vo.dname}}</th>
					<th>{{vo.loc}}</th>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			data(){
				return{
					ld:{} // ld.emp, ld.dept
				}
			},
			// viewModel => 데이터 처리 => 서버에서 데이터 읽기.
			mounted(){
				// => main 메소드 => 서버에서 데이터 읽기
				axios.get('http://localhost:8080/web/emp/list_vue.do')
				.then(response=>{
					console.log(response)
					this.ld=response.data
					// 실행된 데이터 읽기 
				})
			}
		}).mount(".container")
	</script>
</body>
</html>
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
	width: 960px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div class="container" id="app1">
		<div class="row">
			<h3 class="text-center">v-if ~ v-elesif ~ v-else</h3>
			<button class="btn-sm btn-danger" @click="select(1)">한식</button>
			<button class="btn-sm btn-info" @click="select(2)">중식</button>
			<button class="btn-sm btn-primary" @click="select(3)">일식</button>
			<button class="btn-sm btn-success" @click="select(4)">양식</button>
			<button class="btn-sm btn-warning" @click="select(5)">분식</button>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
		    <div v-if="type===1">한식 선택</div>
		    <div v-else-if="type===2">중식 선택</div>
		    <div v-else-if="type===3">일식 선택</div>
		    <div v-else-if="type===4">양식 선택</div>
		    <div v-else-if="type===5">분식 선택</div>
		    <div v-else>음식 선택</div>
		</div>
	</div>
	<div class="container"	id="app2">
		<input type="button" value="로그인" class="btn-sm btn-success" @click="login2()">
		<input type="button" value="로그아웃" class="btn-sm btn-info" @click="logout()">
		<div v-if="login===true">
			로그인 되었습니다.
		</div>
		<div v-else>
			로그아웃 되었습니다.
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			// Model => VO => 데이터 값이 변경되면 HTML로 전송
			data(){
				return {
					type:0
				}
			},
			methods:{
				select:function(no){
					this.type=no
				}
			}
		}).mount("#app1")
		
		let app2=Vue.createApp({
			data(){
				return {
					login:false
				}
			},
			// 변수와 함수명이 동일하면 안된다
			methods:{
				login2:function(){
					this.login=true
				},
				logout:function(){
					this.login=false
				}
			}
		}).mount("#app2")
	</script>
</body>
</html>
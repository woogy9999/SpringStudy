<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row" id="a">
			{{a_msg}}
			<input type=button value="변경" v-on:click="btnClick()">
			
		</div>
		<div class="row" id="b">
			{{b_msg}}
		</div>
	</div>
	<script>
		let bpp=Vue.createApp({
			data(){
				return{
					a_msg:'Hello Vue(a)',
				}
			},
			methods:{
				btnClick:function(){
					this.a_msg='갱신된 값';
					
				}
				
			}
			// ViewModel => 데이터 변경
		}).mount("#a")
		
			let app=Vue.createApp({
			data(){
				return{
					b_msg:'Hello Vue(b)'
				}
			} 
			// ViewModel => 데이터 변경
		}).mount("#b")
	</script>
</body>
</html>
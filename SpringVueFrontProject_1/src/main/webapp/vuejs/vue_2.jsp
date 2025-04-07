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
	<%-- 
			생명주기
			Vue :
				1. 가상 돔 사용 => mount() :속도가 빠르다
					=> 게임 ( 더블 버퍼링 )
					=> String / StringBuffer
					=> 가상메모리를 이용해서 처리
				2. callback => vue에서 지원하는 함수 => 자동 호출이 된다
				-------------------------------------------------
				3. 디렉티브 : 제어문
				4. 서버 연동 : axios
				5. 출력 형식 {{}}
				6. 양방향 => axios
				7. 라우터 : 화면 변경 => Controller
				8. component
				--------------------------------------------------
				9. vue-bootstrap
				10. vue3 => vues
					react => redux
					---------------
					react-query : tanStack-query
					=> Framwork (nextjs)
					 
				
	 --%>
	<div class="container">
		<div class="row">
			<input type="text" class="input-sm" size=20>
			<div class="text-center"></div>
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			data(){
				return{
					msg:''
				}
			},
			beforeCreate(){
				console.log("Vue 객체 생성 전 : beforeCreate() Call")
			},
			created(){
				console.log("Vue 객체 생성 완료 : Create() Call")
			},
			beforeMount(){
				console.log("화면이 출력하기 전 상태 : beforeMount() Call")
			},
			mounted(){
				
			},
			beforeUpdate(){
				
			},
			updated(){
				
			},
			beforeDestory(){
				
			},
			destroyed(){
				
			}
			
			
			
		})
	</script>
</body>
</html>
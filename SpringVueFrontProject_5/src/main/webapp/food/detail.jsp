<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
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
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-center"><img
						:src="'http://www.menupan.com'+detail_vo.poster"
						style="width: 750px; height: 350px"></td>
				</tr>
				<tr>
					<td class="text-center"><h3 id="name">{{detail_vo.name}}</h3></td>
				</tr>
				<tr>
					<td>{{detail_vo.content}}</td>
				</tr>
				<tr>
					<td>{{detail_vo.address}}</td>
				</tr>
				<tr>
				<td>
				<div style="text-align: right;">
				  <input type="button" onclick="history.back()" value="목록" class="btn-sm btn-danger">
				</div>
				
				</td>
				</tr>
			</table>
			
		</div>
	</div>
</body>
<script>
	let detailApp=Vue.createApp({
		data(){
			return{
				fno:${param.fno},
				detail_vo:{},
				address:''
			}
		},mounted(){
			axios.get('http://localhost:8080/web/food/detail_vue.do',{
				params:{
					fno:this.fno
				}		
			}).then(response=>{
				console.log(response.data)
				this.detail_vo=response.data.vo
				this.address=response.data.address
				
				if(window.kakao && window.kakao.maps)
				{
					this.initMap()
				}else{
					this.addScript()
				}
			}).catch(error=>{
				console.log(error.response)
			})
		},methods:{
			addScript(){
    			const script=document.createElement("script") // <script>
    			script.onload=()=>kakao.maps.load(this.initMap)
    			script.src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=0776a8d199dc3f39cb4a1c340a565fcc&libraries=services"
    			document.head.appendChild(script)
    		},
			initMap(){
    			
    			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    		    mapOption = {
    		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    		        level: 3 // 지도의 확대 레벨
    		    };  

    		// 지도를 생성합니다    
    		var map = new kakao.maps.Map(mapContainer, mapOption); 

    		// 주소-좌표 변환 객체를 생성합니다
    		var geocoder = new kakao.maps.services.Geocoder();

    		// 주소로 좌표를 검색합니다
    		geocoder.addressSearch(this.address, function(result, status) {
    		    // 정상적으로 검색이 완료됐으면 
    		     if (status === kakao.maps.services.Status.OK) {

    		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    		        // 결과값으로 받은 위치를 마커로 표시합니다
    		        var marker = new kakao.maps.Marker({
    		            map: map,
    		            position: coords
    		        });

    		        // 인포윈도우로 장소에 대한 설명을 표시합니다
    		        var infowindow = new kakao.maps.InfoWindow({
    		            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
    		        });
    		        infowindow.open(map, marker);

    		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    		        map.setCenter(coords);
    		    } 
    		});    
    		}
		}
	}).mount(".container")
</script>
</html>
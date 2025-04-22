<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/map.css">
</head>
<body>
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="bradcumb-title text-center">
						<h2>상세보기</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="breadcumb-nav">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-home" aria-hidden="true"></i></a></li>
							<li class="breadcrumb-item active" aria-current="page"></li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<section class="archive-area section_padding_80" id="listApp">
		<div class="container">
			<div class="row">
				<table class="table">
					<tr>
						<td class="text-center" colspan="2"><img src="${vo.poster }"
							style="width: 700px; height: 250px;"></td>
					</tr>
					<tr>
						<td width="20%">주소</td>
						<td width="80%">${vo.address}</td>
					</tr>
					<tr>
						<td width="20%">전화</td>
						<td width="80%">${vo.phone}</td>
					</tr>
					<tr>
						<td width="20%">교통정보/운영시간</td>
						<td width="80%">${vo.info}</td>
					</tr>
				</table>

			</div>
			<div style="height: 10px"></div>
			<div class="row">
				<%-- 지도출력 --%>
				<div class="map_wrap">
					<div id="map"
						style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

					<div id="menu_wrap" class="bg_white">
						<div class="option">
							<div>
								<form onsubmit="searchPlaces(); return false;">
									키워드 : <input type="text" value="${addr }" id="keyword"
										size="15">
									<button type="submit">검색하기</button>
								</form>
							</div>
						</div>
						<hr>
						<ul id="placesList"></ul>
						<div id="pagination"></div>
					</div>
				</div>

				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0776a8d199dc3f39cb4a1c340a565fcc&libraries=services"></script>
				<script>
					// 마커를 담을 배열입니다
					var markers = [];

					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
						level : 3
					// 지도의 확대 레벨
					};

					// 지도를 생성합니다    
					var map = new kakao.maps.Map(mapContainer, mapOption);

					// 장소 검색 객체를 생성합니다
					var ps = new kakao.maps.services.Places();

					// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
					var infowindow = new kakao.maps.InfoWindow({
						zIndex : 1
					});

					// 키워드로 장소를 검색합니다
					searchPlaces();

					// 키워드 검색을 요청하는 함수입니다
					function searchPlaces() {

						var keyword = document.getElementById('keyword').value;

						if (!keyword.replace(/^\s+|\s+$/g, '')) {
							alert('키워드를 입력해주세요!');
							return false;
						}

						// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
						ps.keywordSearch(keyword, placesSearchCB);
					}

					// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
					function placesSearchCB(data, status, pagination) {
						if (status === kakao.maps.services.Status.OK) {

							// 정상적으로 검색이 완료됐으면
							// 검색 목록과 마커를 표출합니다
							displayPlaces(data);

							// 페이지 번호를 표출합니다
							displayPagination(pagination);

						} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

							alert('검색 결과가 존재하지 않습니다.');
							return;

						} else if (status === kakao.maps.services.Status.ERROR) {

							alert('검색 결과 중 오류가 발생했습니다.');
							return;

						}
					}

					// 검색 결과 목록과 마커를 표출하는 함수입니다
					function displayPlaces(places) {

						var listEl = document.getElementById('placesList'), menuEl = document
								.getElementById('menu_wrap'), fragment = document
								.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

						// 검색 결과 목록에 추가된 항목들을 제거합니다
						removeAllChildNods(listEl);

						// 지도에 표시되고 있는 마커를 제거합니다
						removeMarker();

						for (var i = 0; i < places.length; i++) {

							// 마커를 생성하고 지도에 표시합니다
							var placePosition = new kakao.maps.LatLng(
									places[i].y, places[i].x), marker = addMarker(
									placePosition, i), itemEl = getListItem(i,
									places[i]); // 검색 결과 항목 Element를 생성합니다

							// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
							// LatLngBounds 객체에 좌표를 추가합니다
							bounds.extend(placePosition);

							// 마커와 검색결과 항목에 mouseover 했을때
							// 해당 장소에 인포윈도우에 장소명을 표시합니다
							// mouseout 했을 때는 인포윈도우를 닫습니다
							(function(marker, title) {
								kakao.maps.event.addListener(marker,
										'mouseover', function() {
											displayInfowindow(marker, title);
										});

								kakao.maps.event.addListener(marker,
										'mouseout', function() {
											infowindow.close();
										});

								itemEl.onmouseover = function() {
									displayInfowindow(marker, title);
								};

								itemEl.onmouseout = function() {
									infowindow.close();
								};
							})(marker, places[i].place_name);

							fragment.appendChild(itemEl);
						}

						// 검색결과 항목들을 검색결과 목록 Element에 추가합니다
						listEl.appendChild(fragment);
						menuEl.scrollTop = 0;

						// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
						map.setBounds(bounds);
					}

					// 검색결과 항목을 Element로 반환하는 함수입니다
					function getListItem(index, places) {

						var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
								+ (index + 1)
								+ '"></span>'
								+ '<div class="info">'
								+ '   <h5>'
								+ places.place_name + '</h5>';

						if (places.road_address_name) {
							itemStr += '    <span>' + places.road_address_name
									+ '</span>'
									+ '   <span class="jibun gray">'
									+ places.address_name + '</span>';
						} else {
							itemStr += '    <span>' + places.address_name
									+ '</span>';
						}

						itemStr += '  <span class="tel">' + places.phone
								+ '</span>' + '</div>';

						el.innerHTML = itemStr;
						el.className = 'item';

						return el;
					}

					// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
					function addMarker(position, idx, title) {
						var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
						imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
						imgOptions = {
							spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
							spriteOrigin : new kakao.maps.Point(0,
									(idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
							offset : new kakao.maps.Point(13, 37)
						// 마커 좌표에 일치시킬 이미지 내에서의 좌표
						}, markerImage = new kakao.maps.MarkerImage(imageSrc,
								imageSize, imgOptions), marker = new kakao.maps.Marker(
								{
									position : position, // 마커의 위치
									image : markerImage
								});

						marker.setMap(map); // 지도 위에 마커를 표출합니다
						markers.push(marker); // 배열에 생성된 마커를 추가합니다

						return marker;
					}

					// 지도 위에 표시되고 있는 마커를 모두 제거합니다
					function removeMarker() {
						for (var i = 0; i < markers.length; i++) {
							markers[i].setMap(null);
						}
						markers = [];
					}

					// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
					function displayPagination(pagination) {
						var paginationEl = document
								.getElementById('pagination'), fragment = document
								.createDocumentFragment(), i;

						// 기존에 추가된 페이지번호를 삭제합니다
						while (paginationEl.hasChildNodes()) {
							paginationEl.removeChild(paginationEl.lastChild);
						}

						for (i = 1; i <= pagination.last; i++) {
							var el = document.createElement('a');
							el.href = "#";
							el.innerHTML = i;

							if (i === pagination.current) {
								el.className = 'on';
							} else {
								el.onclick = (function(i) {
									return function() {
										pagination.gotoPage(i);
									}
								})(i);
							}

							fragment.appendChild(el);
						}
						paginationEl.appendChild(fragment);
					}

					// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
					// 인포윈도우에 장소명을 표시합니다
					function displayInfowindow(marker, title) {
						var content = '<div style="padding:5px;z-index:1;">'
								+ title + '</div>';

						infowindow.setContent(content);
						infowindow.open(map, marker);
					}

					// 검색결과 목록의 자식 Element를 제거하는 함수입니다
					function removeAllChildNods(el) {
						while (el.hasChildNodes()) {
							el.removeChild(el.lastChild);
						}
					}
				</script>
			</div>
			<div style="height: 10px"></div>

			<div id="replyApp">
				<div class="comment_area section_padding_50 clearfix">
					<h4 class="mb-30">댓글</h4>

					<ol>
						<!-- Single Comment Area -->
						<li class="single_comment_area" v-for="vo in reply_list">
							<div class="comment-wrapper d-flex" v-if="vo.group_step===0">
								<!-- Comment Meta -->
								<div class="comment-author">
									<img :src="vo.sex==='남자'?'../img/man.png':'../img/woman.png'" alt="">
								</div>
								<!-- Comment Content -->
								<div class="comment-content">
									<span class="comment-date text-muted">{{vo.dbday}}</span>
									<h5>{{vo.username}}</h5>
									<p>{{vo.msg}}</p>
									<button v-if="sessionId===vo.id" class="btn-xs btn-danger update" 
									style="margin-left: 2px" @click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">Update</button>
									<button v-if="sessionId===vo.id" class="btn-xs btn-info"
										style="margin-left: 2px" @click="replyDelete(vo.cno)">Delete</button>
									<button class="active insert" v-if="sessionId!=''" style="margin-left: 2px" 
									@click="replyForm(vo.cno)" :id="'i'+vo.cno">Reply</button>
									<button v-if="sessionId!==vo.id && sessionId!==''"
										style="margin-left: 2px">Like</button>
									<table class="table ins" style="display: none"
										:id="'in'+vo.cno">
										<tr>
											<td><textarea rows="4" cols="60" style="float: left" :id="'msg'+vo.cno"></textarea> 
											<input type=button value="댓글" style="float: left; background-color: blue; 
											color: white; width: 80px; height: 94px" @click="replyReplyInsert(vo.cno)">
											</td>
										</tr>
									</table>

									<table class="table ups" style="display: none" :id="'up'+vo.cno">
										<tr>
											<td><textarea rows="4" cols="60" style="float: left"
													:id="'umsg'+vo.cno">{{vo.msg}}</textarea> 
											 	<input type=button value="수정"
												style="float: left; background-color: blue; color: white; width: 80px; height: 94px"
												@click="replyUpdate(vo.cno)">
											</td>
										</tr>
									</table>
								</div>
							</div>

							<ol class="children" v-if="vo.group_step===1">
								<li class="single_comment_area">
									<div class="comment-wrapper d-flex">
										<!-- Comment Meta -->
										<div class="comment-author">
											<img :src="vo.sex==='남자'?'../img/icon/man.png':'../img/icon/woman.png'" alt="">
										</div>
										<!-- Comment Content -->
										<div class="comment-content">
											<span class="comment-date text-muted">{{vo.dbday}}</span>
											<h5>{{vo.name}}</h5>
											<p>{{vo.msg}}</p>
											<button v-if="sessionId===vo.id" class="btn-xs btn-danger"
												style="margin-left: 2px" @click="replyUpdateForm(vo.cno)"
												:id="'u'+vo.cno">Update</button>
											<button v-if="sessionId===vo.id" class="btn-xs btn-info"
												style="margin-left: 2px" @click="replyDelete(vo.cno)">Delete</button>
											<button v-if="sessionId!==vo.id && sessionId!==''"
												style="margin-left: 2px">Like</button>
											<table class="table ups" style="display: none"
												:id="'up'+vo.cno">
												<tr>
													<td><textarea rows="4" cols="45" style="float: left"
															:id="'umsg'+vo.cno">{{vo.msg}}</textarea> <input
														type=button value="수정"
														style="float: left; background-color: blue; color: white; width: 80px; height: 94px"
														@click="replyUpdate(vo.cno)">
													</td>
												</tr>
											</table>
										</div>
									</div>
								</li>
							</ol>
						</li>

					</ol>
				</div>
				<!--  페이지  -->
				<!-- Leave A Comment -->
				<c:if test="${sessionScope.userId!=null }">
					<div class="leave-comment-area section_padding_50 clearfix">
						<div class="comment-form">
							<table class="table">
								<tr>
									<td><textarea rows="4" cols="70" style="float: left"
											ref="msg" v-model="msg"></textarea> <input type=button
										value="댓글"
										style="float: left; background-color: blue; color: white; width: 80px; height: 94px"
										@click="replyInsert()">

									</td>
								</tr>
							</table>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</section>
	<script>
		let replyApp=Vue.createApp({
			data(){
				return {
					reply_list:[],
					cno:${vo.no},
					type:1,
					curpage:1,
					sessionId:'${sessionId}',
					totalpage:0,
					startPage:0,
					endPage:0
				}
			},
			mounted(){
				this.dataRecv()
			},
			methods:{
				replyInsert(){
					
				},
				dataRecv(){
					axios.get("../comment/list_vue",{
						params:{
							page:this.curpage,
							cno:this.cno,
							type:this.type
						}
					}).then(res=>{
						console.log(res.data)
						this.reply_list=res.data.list
						this.curpage=res.data.curpage
						this.totalpage=res.data.totalpage
						this.startPage=res.data.startPage
						this.endPage=res.data.endPage
						
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount("#replyApp")
	</script>
</body>
</html>
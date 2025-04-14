<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>캠박 메인</title>
  <style>
    * { margin: 0; padding: 0; box-sizing: border-box; }
    body { font-family: 'Noto Sans KR', sans-serif; line-height: 1.6; color: #333; }
    a { text-decoration: none; color: inherit; }

    /* 헤더 */
    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 20px 10%;
      background-color: #fff;
      box-shadow: 0 2px 8px rgba(0,0,0,0.05);
      position: sticky;
      top: 0;
      z-index: 1000;
    }
    .logo { font-size: 24px; font-weight: bold; color: #00704a; }
    nav a { margin-left: 30px; font-size: 16px; }

    /* 배너 */
    .main-banner {
      background-image: url('https://cambak.co.kr/_next/static/media/main_banner.78f1e59f.jpg');
      background-size: cover;
      background-position: center;
      height: 500px;
      display: flex;
      justify-content: center;
      align-items: center;
      color: white;
      text-shadow: 0 0 10px rgba(0,0,0,0.4);
      font-size: 36px;
      font-weight: bold;
    }

    /* 캠핑장 목록 */
    .section {
      padding: 60px 10%;
    }
    .section h2 {
      font-size: 28px;
      margin-bottom: 30px;
      color: #222;
    }
    .camp-list {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
      gap: 20px;
    }
    .camp-item {
      border-radius: 10px;
      overflow: hidden;
      box-shadow: 0 2px 10px rgba(0,0,0,0.05);
      transition: transform 0.2s;
    }
    .camp-item:hover { transform: translateY(-5px); }
    .camp-item img {
      width: 100%;
      height: 160px;
      object-fit: cover;
    }
    .camp-item div {
      padding: 15px;
      font-weight: 500;
    }

    /* 지역 버튼 */
    .region-filter {
      display: flex;
      flex-wrap: wrap;
      gap: 10px;
      margin-top: 20px;
    }
    .region-filter button {
      border: 1px solid #ccc;
      background: #f9f9f9;
      padding: 10px 20px;
      border-radius: 20px;
      cursor: pointer;
      transition: background 0.2s;
    }
    .region-filter button:hover {
      background: #00704a;
      color: white;
      border-color: #00704a;
    }
  </style>
</head>
<body>

  <header>
    <div class="logo">CAMBAK</div>
    <nav>
      <a href="#">캠핑장</a>
      <a href="#">리뷰</a>
      <a href="#">이벤트</a>
      <a href="#">마이페이지</a>
    </nav>
  </header>

  <section class="main-banner">
    캠핑이 필요할 때, CAMBAK
  </section>

  <section class="section">
    <h2>🔥 인기 캠핑장</h2>
    <div class="camp-list">
      <div class="camp-item">
        <img src="https://picsum.photos/300/200?1" alt="캠핑1">
        <div>산속 힐링 캠핑장</div>
      </div>
      <div class="camp-item">
        <img src="https://picsum.photos/300/200?2" alt="캠핑2">
        <div>바다뷰 감성 캠핑</div>
      </div>
      <div class="camp-item">
        <img src="https://picsum.photos/300/200?3" alt="캠핑3">
        <div>숲속 오토 캠핑장</div>
      </div>
    </div>
  </section>

  <section class="section">
    <h2>📍 지역별 보기</h2>
    <div class="region-filter">
      <button>서울</button>
      <button>경기</button>
      <button>강원</button>
      <button>전라</button>
      <button>경상</button>
      <button>제주</button>
    </div>
  </section>

</body>
</html>

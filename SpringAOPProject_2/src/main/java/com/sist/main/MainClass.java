package com.sist.main;

// Proxy => 대리자 => AOP

/*
  		프로그램 => 핵심 코드
  			     ---------
  			     부가적인 코드 => 모아서 관리 => 공통모듈 / AOP
  			      | 데이터베이스 연결 / 데이터베이스 해제
  			      | 보안 (인가 => 인증)
  			      | 트랜잭션 => commit / rollback
  			      | 로깅
  			      | 파일 입출력
  			      ------------------------------- AOP 라이브러리
  			      | 사용자 정의 AOP(한두번)
  			      ---------------- 인터셉트 (자동 로그인) ,AOP
  		
  		중복 제거 => 메소드화 처리
  		---------------------- CallBack
  		AOP의 개념
  		1. Aspect : 공통으로 적용되는 기능을 모아둔 장소 => 공통 모듈
  		2. Target : 적용하는 곳 => 모아주는 역할
  		3. Advice : 어디에 어떤 기능을 추가할 지
  		4. JoinPoint : 시점 => 어디서 호출
  					  Befor
  					  After
  					  After-Returning
  					  After-Throwing
  					  Around
  					  
  					  public void display()
  					  {
  					  }
  		5. PointCut
 
 */
public class MainClass {
		
	public static void main(String[] args) {
		My m=new My();
		m.execute();
		MyTarget mt=new MyTarget(m);
		mt.execute();
		
	}
}

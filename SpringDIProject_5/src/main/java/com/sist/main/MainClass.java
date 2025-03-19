package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 
 * 
 * 			1) DI => 주입
 * 			   --- LOC => DI
 * 				범위 => 클래스와 클래스의 연관 관계를 설정 (클래스 다이어그램)
 * 					   => p:객체명-ref="id명"
 * 						  클래스에 필요한 데이터 주입
 * 						  ----------------------
 * 						  => p:변수명 ="값"
 * 						  ---------------
 * 							setter /constructor
 * 						------------------------ xml에서만 가능
 							어노테이션에서는 사용이 불가능
 			클래스 한개 메모리 할당
 			 <bean>
 			클래스 여러개를 한번에 메모리 할당
 			 <context:component-scan basepackage="">
 			 => 선별해서 메모리 할당 요청
 			 			------------ 메모리에 할당된 객체만 스프링이 관리 
 			 	@Controller
 			 	@Component
 			 	@Repository
 			 	@Service
 			 	@RestController
 			 	@ControllerAdvice
 			 	@RestControllerAdvice
 			 	
 			 	1) 클래스를 한개씩 <bean>
 			 		xml
 			 	2) 모든 클래스를 한번에 등록 : 패키지 단위
 			 		Annotation
 			 	3) xml+ Annotation : 실제 사용
 			 	
 */
import com.sist.goods.*;
import com.sist.member.*;
import com.sist.sawon.*;

public class MainClass {
	public static void main(String[] args) {

		// 동록한 xml을 컨테이너로 전송
		ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml");

		SawonManager s = (SawonManager) app.getBean("sa");
		s.display();
		MemberManager m = (MemberManager) app.getBean("mem");
		m.display();
		GoodsManager g = (GoodsManager) app.getBean("goods");
		g.display();
		
	}
}

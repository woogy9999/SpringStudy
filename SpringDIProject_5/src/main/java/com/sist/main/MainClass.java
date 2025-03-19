package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 
 * 
 * 			1) DI => ����
 * 			   --- LOC => DI
 * 				���� => Ŭ������ Ŭ������ ���� ���踦 ���� (Ŭ���� ���̾�׷�)
 * 					   => p:��ü��-ref="id��"
 * 						  Ŭ������ �ʿ��� ������ ����
 * 						  ----------------------
 * 						  => p:������ ="��"
 * 						  ---------------
 * 							setter /constructor
 * 						------------------------ xml������ ����
 							������̼ǿ����� ����� �Ұ���
 			Ŭ���� �Ѱ� �޸� �Ҵ�
 			 <bean>
 			Ŭ���� �������� �ѹ��� �޸� �Ҵ�
 			 <context:component-scan basepackage="">
 			 => �����ؼ� �޸� �Ҵ� ��û
 			 			------------ �޸𸮿� �Ҵ�� ��ü�� �������� ���� 
 			 	@Controller
 			 	@Component
 			 	@Repository
 			 	@Service
 			 	@RestController
 			 	@ControllerAdvice
 			 	@RestControllerAdvice
 			 	
 			 	1) Ŭ������ �Ѱ��� <bean>
 			 		xml
 			 	2) ��� Ŭ������ �ѹ��� ��� : ��Ű�� ����
 			 		Annotation
 			 	3) xml+ Annotation : ���� ���
 			 	
 */
import com.sist.goods.*;
import com.sist.member.*;
import com.sist.sawon.*;

public class MainClass {
	public static void main(String[] args) {

		// ������ xml�� �����̳ʷ� ����
		ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml");

		SawonManager s = (SawonManager) app.getBean("sa");
		s.display();
		MemberManager m = (MemberManager) app.getBean("mem");
		m.display();
		GoodsManager g = (GoodsManager) app.getBean("goods");
		g.display();
		
	}
}

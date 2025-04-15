package com.sist.manager;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.*;
import com.sist.vo.*;

@ServerEndpoint(value = "/site/chat/chat-ws", configurator = WebSocketSessionConfigurator.class)
public class ChatServer {
	private static Map<Session, MemberVO> users = Collections.synchronizedMap(new HashMap<Session, MemberVO>());

	// 접속시 처리
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) throws Exception {
		
		MemberVO vo = new MemberVO();
		HttpSession hs =(HttpSession)config.getUserProperties().get(HttpSession.class.getName());
		vo=(MemberVO)hs.getAttribute("vo");
		vo.setSession(session);
		System.out.println("1. 접속"+vo.getName());
		
		System.out.println("HttpSession 가져왔나? => " + hs); // null이면 세션 공유 안된거야
		System.out.println("세션에 있는 vo => " + vo);       // null이면 로그인 정보 없음
		
		
		// 접속자 목록에 저장
		users.put(session, vo);
		// 입장 메세지 전송
		Iterator<Session> it=users.keySet().iterator();
		while(it.hasNext())
		{
			Session ss=it.next();
			// 본인이 아닌 모든 접속자에게
			if(ss.getId()!=session.getId())
			{
			 ss.getBasicRemote().sendText("msg:[알림 👉]"+vo.getName()+"님이 입장하셨습니다.");	
			}
		}
		System.out.println("클라이언트 접속:"+vo.getName()+","+session.getId());
	}
	// => 전체 메세지 / 개인 메세지 => 메소드 => switch
	// 채팅 메세지
	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		
		System.out.println("수신 메세지:"+message+"===보낸사람:"+users.get(session).getName());
		Iterator<Session> it=users.keySet().iterator();
		while(it.hasNext())
		{
			Session ss=it.next();
			MemberVO vo = users.get(session);
			ss.getBasicRemote().sendText("msg:["+vo.getName()+"]"+message);
		}
	}

	// 종료
	@OnClose
	public void onClose(Session session) throws Exception {
			Iterator<Session> it=users.keySet().iterator();
			while(it.hasNext())
			{
				Session ss=it.next();
				MemberVO vo=users.get(session);
				
				if(ss.getId()!=session.getId())
				{
				 ss.getBasicRemote().sendText("msg:[알림 👉]"+vo.getName()+"님이 퇴장하셨습니다.");	
				}
			}
			System.out.println("클라이언트 퇴장"+users.get(session).getName());
			users.remove(session);
	}

}

package com.lth.handler;

import java.util.ArrayList;

import java.util.List;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Controller
@RequestMapping("/echo") 
public class EchoHandler extends TextWebSocketHandler{


	/* ������ ������ ������ ����Ʈ ���� */
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	

	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{ // ���� ������ ��
		System.out.println("���� �Ϸ�");
		sessionList.add(session);	
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{ // �޼����� ���۵� ��
		String msg = message.getPayload().toString();	//�Ķ���ͷ� �޾ƿ� �޽����� ��´�(json������ ���ڿ��� ���� ��ܿԴ�. chatting.jsp sendMessage()�Լ� ����)
		JSONParser jparser=new JSONParser();			//json ������ ���ڿ��� json���� ��ȯ �ϱ����� 	�ļ�
		JSONObject obj=(JSONObject)jparser.parse(msg);  //�ļ��� �̿��ؼ� json���·� ��´�

		String messageStr=obj.get("message").toString();//�޽��� ���� , �ۼ���id,��id�� ��� ���ڿ��� �޾Ҵ�!! ���� ���� �����͸� Vo�� ���� db�� �־��ټ� �ִ�
		String idStr=obj.get("id").toString();
		String roomIdStr=obj.get("roomId").toString();
		
		/*
		 * 
		 *���⼭ db�������ָ� �� 
		 */
		
		for(WebSocketSession sess: sessionList) {
			//�̰� �����ϰ� ������ chatting.jsp ��ũ��Ʈ�κ� ����
			//�޽��� ���ų� ������ �ڵ����� ȣ��Ǵ� onMessage(msg) �Լ��� ���� �Ķ���� msg�� �޽����� ������.
			//�� ���⼭ �̷������� �����ָ� onMessage(msg)�� ȣ��Ǿ������̴�.
			sess.sendMessage(new TextMessage(msg));
		}
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{ // ������ ���� ��
		System.out.println("���� ����");
		sessionList.remove(session);
	}
	
}

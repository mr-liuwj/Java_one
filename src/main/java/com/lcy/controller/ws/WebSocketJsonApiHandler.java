package com.lcy.controller.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


/**
 * 
 * <p>description: websocket json  Api 处理类</p>  
 */
@Service
public class WebSocketJsonApiHandler extends TextWebSocketHandler{

	private final Logger logger=LoggerFactory.getLogger(WebSocketJsonApiHandler.class);
	

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		logger.info("有新的WebSocket连接建立 {}，等候初始化",session.getId());
		session.sendMessage(new TextMessage("哈哈哈"));
	}


	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		logger.info("建立 {} WebSocket连接 {}",message.getPayload(),session.getId());
		session.sendMessage(new TextMessage("婆婆"));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		logger.info(" {} 传输失败",session.getId());
		logger.error("",exception);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("移除 {} WebSocket连接 {}", session.getRemoteAddress(),session.getId());
	}

	
	
}

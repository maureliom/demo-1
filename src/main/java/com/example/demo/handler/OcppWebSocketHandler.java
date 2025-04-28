package com.example.demo.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class OcppWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received: " + message.getPayload());
        String response = "{\"jsonrpc\": \"2.0\", \"id\": \"1\", \"result\": {\"status\": \"Accepted\"}}";
        session.sendMessage(new TextMessage(response));
    }
}
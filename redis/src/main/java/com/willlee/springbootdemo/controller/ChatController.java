package com.willlee.springbootdemo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.willlee.springbootdemo.domain.WebSocketRequestMessage;

@Controller
public class ChatController {

	@MessageMapping("/send")
	@SendTo("/topic/getResponse")
	public WebSocketRequestMessage chatResponse(WebSocketRequestMessage message) {
		String response = "lalala";
		return new WebSocketRequestMessage(response);
	}
	
}

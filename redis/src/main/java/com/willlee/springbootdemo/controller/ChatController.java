package com.willlee.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.willlee.springbootdemo.domain.User;
import com.willlee.springbootdemo.domain.WebSocketMessage;

@Controller
public class ChatController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@MessageMapping("/sendWebSocketMessage")
	@SendTo("/topic/getResponse")
	public WebSocketMessage chatResponse(WebSocketMessage message) {
		User user = (User) redisTemplate.opsForValue().get(message.getUseraccount());
		message.setHeadicon(user.getHeadicon());
		return message;
	}
}

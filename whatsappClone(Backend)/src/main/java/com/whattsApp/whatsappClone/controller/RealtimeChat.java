package com.whattsApp.whatsappClone.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.whattsApp.whatsappClone.Model.Message;


@Controller
public class RealtimeChat {
	
	private final SimpMessagingTemplate simpleMessagingTemplate;

	public RealtimeChat(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpleMessagingTemplate = simpMessagingTemplate;
	}
	
	@MessageMapping("/message")
	@SendTo("/goup/public")
	public Message reciveMessage(@Payload Message message) {
		simpleMessagingTemplate.convertAndSend("/goup/"+ message.getChat().getId().toString(), message);
		return message;
	}
	
	
	

}

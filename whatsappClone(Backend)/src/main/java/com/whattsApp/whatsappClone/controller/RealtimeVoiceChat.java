package com.whattsApp.whatsappClone.controller;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.whattsApp.whatsappClone.Model.Message;


@Controller
public class RealtimeVoiceChat {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public RealtimeVoiceChat(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/voice")
    @SendTo("/voicegroup/public")
    public byte[] receiveVoiceMessage(@Payload Message voiceMessage) {
        simpMessagingTemplate.convertAndSend("/voicegroup/" + voiceMessage.getChat().getId().toString(), voiceMessage);
        return voiceMessage.getAudioData(); // Assuming you have a method getAudioData() in your Message class
    }
}



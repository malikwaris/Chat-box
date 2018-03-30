package com.programmingtest;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
importorg.springframework.messaging.handler.annotation.DestinationVariable;

/*
 * Chat Controller listens for chat topic and responds with a message.
 */
@Controller
public class ChatController 
{
    @MessageMapping("/chat/{topic}")
    @SendTo("/topic/messages")
    public OutputMessage send(@DestinationVariable("topic") String topic,
			      Message message) throws Exception
    {
	return new OutputMessage(message.getFrom(), message.getText(), topic);
    }
}

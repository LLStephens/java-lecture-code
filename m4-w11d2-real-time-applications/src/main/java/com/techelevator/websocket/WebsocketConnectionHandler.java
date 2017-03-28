package com.techelevator.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.techelevator.model.ColorMap;

@Component
public class WebsocketConnectionHandler {
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private ColorMap map;
	
	private int usersConnected = 0;
	
	@EventListener
	public void onConnectEvent(SessionSubscribeEvent event) {
		usersConnected++;
       	template.convertAndSend("/topic/mapUpdate", map);
    }
	
	@EventListener
	public void onDisconnectEvent(SessionDisconnectEvent event) {
		if(--usersConnected == 0) {
			map.resetMap();
		}
	}
}
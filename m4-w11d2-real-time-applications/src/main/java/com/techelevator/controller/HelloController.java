package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.ColorMap;
import com.techelevator.model.MapUpdate;

@Controller 
public class HelloController {
	
	@Autowired
	private ColorMap map;

	@RequestMapping("/")
	public String displayGreeting() {
		return "greeting";
	}
	
	@MessageMapping("/mapUpdate")
	public MapUpdate handleMessage(MapUpdate update) {
		map.setColorFromUpdate(update);
		return update;
	}
		
		
			
}

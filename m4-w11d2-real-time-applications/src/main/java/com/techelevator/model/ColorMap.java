package com.techelevator.model;

import org.springframework.stereotype.Component;

@Component
public class ColorMap {
	private String[][] mapData = new String[10][10];

	public void setColorFromUpdate(MapUpdate update) {
		mapData[update.getX()][update.getY()] = update.getColor();
	}
	
	public void resetMap() {
		mapData = new String[10][10];
	}

	public String[][] getMapData() {
		return mapData;
	}
}

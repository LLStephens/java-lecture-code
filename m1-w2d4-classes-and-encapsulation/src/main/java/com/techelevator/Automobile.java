package com.techelevator;

public class Automobile {
	
	private static final int TOP_SPEED_DRIVE = 100;
	private static final int TOP_SPEED_REVERSE = 10;
	
	private boolean isStarted;
	private boolean isReverse;
	private int currentSpeed;
	
	public Automobile() {
		isStarted = false;
		isReverse = false;
		currentSpeed = 0;
	}
	
	/**
	 * Changes the Automobile's state to started (i.e. turns on the engine).
	 * 
	 * @return true if the engine starts successfully, otherwise false
	 */
	public boolean turnOn() {
		isStarted = true;
		return isStarted;
	}
	
	/**
	 * Changes the Automobile's state to off (i.e. turns off the engine).
	 * 
	 * @return true if the engine is stopped successfully, otherwise false
	 */
	public boolean turnOff() {
		isStarted = false;
		return !isStarted;
	}
	
	/**
	 * @return true if the engine is started, otherwise false;
	 */
	public boolean isStarted() {
		return isStarted;
	}
	
	/**
	 * Changes the Automobile's current gear to reverse.
	 * 
	 * @return true if the gear is successfully changed to reverse, otherwise false
	 */
	public boolean engageReverse() {
		if(isStarted && currentSpeed == 0) {
			isReverse = true;
		}
		return isReverse;
	}
	
	/**
	 * @return true if the gear is reverse, otherwise false
	 */
	public boolean isReverse() {
		return isReverse;
	}
	
	/**
	 * Changes the Automobile's current gear to drive.
	 * 
	 * @return true if the gear is successfully changed to drive, otherwise false
	 */
	public boolean engageDrive() {
		if(isStarted && currentSpeed == 0) {
			isReverse = false;
		}
		return !isReverse;
	}
	
	/**
	 * Increases the current speed.
	 * 
	 * @return the current speed after acceleration
	 */
	public int accelerate() {
		if(isStarted) {
			if(isReverse) {
				currentSpeed = TOP_SPEED_REVERSE > currentSpeed + 1 ? currentSpeed + 1 : TOP_SPEED_REVERSE;
			} else {
				currentSpeed = TOP_SPEED_DRIVE > currentSpeed + 10 ? currentSpeed + 10 : TOP_SPEED_DRIVE;
			}
		}
		return currentSpeed;
	}
	
	/**
	 * Decreases the current speed.
	 * 
	 * @return the current speed after deceleration
	 */
	public int decelerate() {
		currentSpeed = currentSpeed - 10 > 0 ? currentSpeed - 10 : 0;
		return currentSpeed;
	}
	
	/**
	 * @return the current speed
	 */
	public int getCurrentSpeed() {
		return currentSpeed;
	}
}

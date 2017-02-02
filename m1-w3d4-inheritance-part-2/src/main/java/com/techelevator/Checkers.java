package com.techelevator;

public class Checkers extends Game {

	String winner;
	double random = 0.5;
	
	public Checkers() {
		super(2);
	}
	
	public void kingMe(int player) {
		if(player == 0) {
			System.out.println("Red gets a king");
		} else {
			System.out.println("Black gets a king");
		}
	}

	@Override
	public void prepareToPlay() {
		System.out.println("Set up board");
	}

	@Override
	public boolean endOfGame() {
		if(random < 0.1) {
			winner = "Red";
			return true;
		} else if(random > 0.9) {
			winner = "Black";
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void makePlay(int player) {
		random = Math.random();
		if(player == 0) {
			System.out.println("Red's Turn");
		} else {
			System.out.println("Black's Turn");
		}
	}

	@Override
	public void displayWinner() {
		System.out.println(winner + " wins the game!"); 
	}

}









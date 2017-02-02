package com.techelevator;

public abstract class Game {
    
    protected int numberOfPlayers;
    
    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;   
    }
    
    public void playOneGame() {
        prepareToPlay();
        for(int i = 0; !endOfGame(); i = (i + 1) % numberOfPlayers) {
            makePlay(i);
        }  
        displayWinner(); 
    }
    
    public abstract void prepareToPlay();
    
    public abstract boolean endOfGame();
    
    public abstract void makePlay(int player);
    
    public abstract void displayWinner();          
}
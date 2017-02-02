package com.techelevator;
import java.util.ArrayList;
import java.util.List;

public class Monopoly extends Game
{
    public Monopoly(int numberOfMonopolyPlayers)
    {
    	super(numberOfMonopolyPlayers);
    }

    private List<String> players;

    @Override
    public boolean endOfGame()
    {
        return players.size() == 1;
    }

    @Override
    public void prepareToPlay()
    {
        players = new ArrayList<String>();

        for (int i = 1; i <= numberOfPlayers; i++)
        {
            players.add("Player " + i);
            System.out.println("Player " + i + " joined the game and was given $1000");
        }
        
        System.out.println();
    }

    @Override
    public void displayWinner()
    {
    	System.out.println("The remaining player " + players.get(0) + " is the winner!");
    	System.out.println();
    }

    @Override
    public void makePlay(int playerNumber)
    {
        //Randomly make a player get eliminated
        int random = (int)(Math.random() * 100);

        // Eliminate the player if the random number 
        // is divisible by 7
        if (random % 7 == 0)
        {
            System.out.println();
            System.out.print("ELIMINATED  ------ ");
            System.out.println(players.get(playerNumber) + " ran out of $ eliminated!");
            System.out.println();
            
            // Remove player fromthe lineup
            players.remove(playerNumber);
            numberOfPlayers--;
            playerNumber = playerNumber - 1;
        }
        else //let them keep playing
        {
            System.out.println(players.get(playerNumber) + " just took their turn");
        }
    }
}
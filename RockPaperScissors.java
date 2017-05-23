package com.shira;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        System.out.println("Welcome to Shira's Rock-Paper-Scissors Game!");
        //Let the computer pick its number, but don't show it yet.
        String compResult = getComputer();
        String userResult = getUser();
        String winnerResult = getWinner(compResult, userResult);

        System.out.println("You chose " + userResult + ", and the computer chose "
                + compResult + ".");
        System.out.println(winnerResult);
        startOrQuit(args);

    }

    /**
     * The getComputer method gets a random number between 1 and 3,
     * which represents the computer's random choice of Rock, Paper, or Scissors.
     * @return A string containing the computer's choice of "rock", "paper", or "scissors".
     */
    public static String getComputer() {
        Random rand = new Random();
        int compNum = rand.nextInt(3) +1;

        String compItem; //To hold the computer's result of rock, paper or scissors
        switch(compNum) {
            case(1):
                compItem = "rock";
            case(2):
                compItem = "paper";
            case(3):
                compItem = "scissors";
            default:
                compItem = "scissors";
        }
        System.out.println("The computer has chosen his answer, but you have to reveal your answer first. :)");
        return compItem;
    }

    /**
     * The getUser method gets the user's input about which item they choose.
     * The user input is automatically transferred to lowercase to prevent logical errors later on.
     * @return A string containing the user's choice of "rock", "paper", or "scissors".
     */
    public static String getUser() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter rock, paper, or scissors.");
        String userItem = keyboard.nextLine();
        userItem = userItem.toLowerCase();
        while (!userItem.equals("rock") && !userItem.equals("paper") && !userItem.equals("scissors")) {
            System.out.println("Sorry, that's not a valid answer." +
                    " Please type 'rock', 'paper', or 'scissors', followed by enter.");
            userItem = keyboard.nextLine();
            userItem = userItem.toLowerCase();
        }
        return userItem;
    }

    /**
     * The getWinner method compares the user's choice and the computer's choice to determine who won the
     * round of the game. It accepts the results from the getUser and getComputer methods.
     * @param computer The computer's auto-generated choice of "rock", "paper" or "scissors".
     * @param user The user's choice of "rock", "paper", or "scissors".
     * @return A string which either names the winner and congratulates him, or declares it a tie game.
     */
    public static String getWinner(String computer, String user) {
        String winner = "";
        if(!computer.equals(user)) {
            if((computer.equals("rock") && user.equals("scissors"))
                    || (computer.equals("scissors") && user.equals("paper"))
                    || (computer.equals("paper") && user.equals("rock"))) {
                winner = "Computer wins!";
            }
            else if ((user.equals("rock") && computer.equals("scissors"))
                    || (user.equals("scissors") && computer.equals("paper"))
                    || (user.equals("paper") && computer.equals("rock"))) {
                winner = "Congrats! You win!";
            }
        }
        else {
            winner = "It's a tie!";
        }
        return winner;
    }

    /**
     * The startOrQuit method allows the user to choose if he wants to play again or quit.
     * If the user types in an "R" or "r", the game will restart. Otherwise,
     * it will thank the user and end the game.
     */
    private static void startOrQuit(String[] args)
    {
        try{
            System.out.println("Type 'R' to restart or any other key to quit.");
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.nextLine();
            if(input.equals("R") || input.equals("r")) {
                System.out.println("---- Starting a new game -----");
                main(args);
            }
            else
                System.out.println("Thanks for playing! Goodbye!");
        }
        catch(Exception e)
        {e.printStackTrace();}
    }
}

package uoa.assignment.game;

import java.util.Scanner;

public class RunGame {

	public static boolean gameOver = false;
    //set the initial value of gameOver to false
   
	public static void main(String[] args) {
		
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        //get the height and width from the arguments

        int round = 0;
        //set the initial value of round to 0

        Game Game = new Game(height, width);
        //create a new object Game

        while (!gameOver) {
            
            round++;//increment round

            System.out.println("");
            System.out.println("Round " + round);//print the current round number
            
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            //get the input from the user

            Game.nextRound(input);
            //start the next round

        }
    }
}

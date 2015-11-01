package katas.dustin;

import java.util.Scanner;

import katas.dustin.gameoflife.GameOfLife;

public class GameOfLifeAutoRun {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("This application will print out a 'living' game board.");
		System.out.println("Please enter the number of generations you wish to run.");

		Scanner sc = new Scanner(System.in);
	    String line = sc.nextLine();
	    sc.close();
	    
	    int generations = Integer.valueOf(line);
	    GameOfLife game = new GameOfLife();
	    char[][] newState = new char[][] {
				{'.', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'A', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'.', 'A', '.', '.', 'A', 'A', 'A', 'A'},
				{'.', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'A', '.', 'A', '.', 'A', '.', 'A', '.'},
				{'A', 'A', '.', 'A', '.', 'A', '.', '.'}
		};
		game.setState(newState);
	    
	    game.printBoard(System.out);
	    for(int i = 0; i < generations; i++) {
	    	Thread.sleep(300);
	    	game.processSingleLifeCycle();
	    	System.out.println();
	    	game.printBoard(System.out);
	    }
	    System.out.println();
	    
	}

}

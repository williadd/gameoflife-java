package katas.dustin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import katas.dustin.gameoflife.GameOfLife;

public class GameOfLifeAutoRun {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		System.out.println("This is a demonstration of the functionality required for the Game of Life Excercise.");
		System.out.println("Please enter the name of the JSON file containing an 8 wide by 6 tall grid (expecteing a simple 2D array).");
		
		Scanner sc = new Scanner(System.in);
	    String fileName = sc.nextLine();
	    System.out.println("Reading grid from "+fileName);
	    
	    JsonReader rdr = Json.createReader(new FileInputStream(fileName));
    	JsonObject obj = rdr.readObject();
    	JsonArray results = obj.getJsonArray("grid");
    	char[][] board = new char[6][8];
    	
    	for(int r = 0; r < 6; r++) {
    		for(int c = 0; c < 8; c++) {
    			board[r][c] = results.getJsonArray(r).getString(c).toCharArray()[0];
    		}
    	}
    	
		System.out.println("This application will print out a 'living' game board.");
		System.out.println("Please enter the number of generations you wish to run.");

	    String line = sc.nextLine();
	    sc.close();
	    
	    int generations = Integer.valueOf(line);
	    GameOfLife game = new GameOfLife();

		game.setState(board);
	    
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

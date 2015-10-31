package katas.dustin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import katas.dustin.gameoflife.GameOfLife;

public class GameOfLifeKata {

	public static void main(String[] args) throws IOException {
		System.out.println("This is a demonstrattion of the functionality required for the Game of Life Excercise.");
		System.out.println("Please enter the name of the JSON file containing an 8 wide by 6 tall grid (expecteing a simple 2D array).");
		
		Scanner sc = new Scanner(System.in);
	    String fileName = sc.nextLine();
	    sc.close();
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
    	GameOfLife game = new GameOfLife();
    	game.getBoard().setBoard(board);
    	System.out.println("The current board is:");
    	game.printBoard(System.out);
    	System.out.println();
    	System.out.println("The board after one life is:");
    	game.processSingleLifeCycle();
    	game.printBoard(System.out);
    	System.out.println();
	}
}

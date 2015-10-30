package katas.dustin;

import katas.dustin.gameoflife.Board;

public class GameOfLife {
	
	private Board board;
	
	public GameOfLife() {
		this.board = new Board(8, 6);
	}
	
	public Board getBoard() {
		return board;
	}
	
	public int[][] getState() {
		return board.getBoard();
	}
	
	public void setState(int[][] state) {
		this.board.setBoard(state);
	}

}

package katas.dustin.gameoflife;

public class Board {
	
	private int[][] board;
	
	
	public Board(int width, int height) {
		board = new int[height][width];
	}
	
	public int getWidth() {
		return board[0].length;
	}
	
	public int getHeight() {
		return board.length;
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public void setBoard(int[][] board) {
		this.board = board;
	}
}

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
	
	public char[][] getState() {
		return board.getBoard();
	}
	
	public void setState(char[][] state) {
		this.board.setBoard(state);
	}
	
	public char nextStateOf(int row, int col) {
		int liveNeighborCount = board.getLiveNighborCount(row, col);
		char currentState = board.getBoard()[row][col];
		char nextState;
		switch(currentState) {
		case 'A' : 
			nextState = calculateNextStateOfLiveCell(liveNeighborCount);
			break;
		default :
			nextState = 'X';
		}
		return nextState;
	}

	private char calculateNextStateOfLiveCell(int liveNeighborCount) {
		char nextState;
		if(liveNeighborCount < 2 || liveNeighborCount > 3) {
			nextState = '.';
		} else {
			nextState = 'A';
		}
		return nextState;
	}
}

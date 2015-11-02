package katas.dustin.gameoflife;

import java.io.PrintStream;


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
		case '.' :
			nextState = calculateNextStateOfDeadCell(liveNeighborCount);
			break;
		default :
			nextState = 'X';
		}
		return nextState;
	}
	
	private char calculateNextStateOfDeadCell(int liveNeighborCount) {
		char nextState;
		if(liveNeighborCount == 3) {
			nextState = 'A';
		} else {
			nextState = '.';
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
	
	public void processSingleLifeCycle() {
		char[][] nextLife = new char[getBoard().getHeight()][getBoard().getWidth()];
		for(int r = 0; r < getBoard().getHeight(); r++) {
			for(int c = 0; c < getBoard().getWidth(); c++) {
				nextLife[r][c] = nextStateOf(r, c);
			}
		}
		setState(nextLife);
	}
	
	public void printBoard(PrintStream out) {
		for(int r = 0; r < getBoard().getHeight(); r++) {
			out.println();
			for(int c = 0; c < getBoard().getWidth(); c++) {
				out.print(getState()[r][c]);
			}
		}
	}
}

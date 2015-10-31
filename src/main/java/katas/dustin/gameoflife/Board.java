package katas.dustin.gameoflife;

public class Board {
	
	private int rows;
	private int cols;
	
	private Cell[][] board;
	
	
	public Board(int width, int height) {
		//TODO we're assuming width and height are always greater than 0
		
		this.rows = height;
		this.cols = width;
		
		board = buildBoard(width, height);
	}
	
	private static Cell safeGetCell(Cell[][] board, int row, int col) {
		Cell result = null;
		try {
			result = board[row][col];
		} catch(ArrayIndexOutOfBoundsException e) {
			result = null;
		}
		return result;
	}
	
	private void attemptLinkNeighbors(Cell cell1, Cell cell2) {
		if(cell1 != null && cell2 != null) {
			cell1.addNeighbor(cell2);
			cell2.addNeighbor(cell1);
		}
	}
	
	private Cell[][] buildBoard(int width, int height) {
		
		Cell[][] tempBoard = new Cell[height][width];

		for(int r = 0; r < height; r++) {
			for(int c = 0; c < width; c++) {
				tempBoard[r][c] = new Cell();
				attemptLinkNeighbors(tempBoard[r][c], safeGetCell(tempBoard, r, c-1)); //cell to the left
				attemptLinkNeighbors(tempBoard[r][c], safeGetCell(tempBoard, r-1, c-1)); // cell to the upper left
				attemptLinkNeighbors(tempBoard[r][c], safeGetCell(tempBoard, r-1, c)); // cell above
				attemptLinkNeighbors(tempBoard[r][c], safeGetCell(tempBoard, r-1, c+1)); // cell to the upper right
			}
		}
		
		return tempBoard;
		
	}
	
	public int getWidth() {
		return cols;
	}
	
	public int getHeight() {
		return rows;
	}
	
	public char[][] getBoard() {
		char[][] result = new char[getHeight()][getWidth()];
		for(int i = 0; i < getHeight(); i++) {
			for(int j = 0; j < getWidth(); j++) {
				result[i][j] = board[i][j].isAlive() ? 'A' : '.';
			}
		}
		return result;
	}
	
	public void setBoard(char[][] newBoard) {
		//TODO Would be nice to make sure the new board size is the same as the existing board size
		// TODO right now assumes A or anything else for alive or dead
		this.board = buildBoard(getWidth(), getHeight());
		for(int i = 0; i < getHeight(); i++) {
			for(int j = 0; j < getWidth(); j++) {
				board[i][j].setAlive(newBoard[i][j] == 'A');
			}
		}
	}
	
	public int getLiveNighborCount(int r, int c) {
		int sum = 0;
		for(Cell cell : this.board[r][c].getNeighbors()) {
			if(cell.isAlive()) { sum += 1; }
		}
		return sum;
	}
}

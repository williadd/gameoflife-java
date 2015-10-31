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
//		//link the non-edge cells
//		for(int x = 1; x < height-1; x++) {
//			for(int y = 1; y < width-1; y++) {
//				tempBoard[x][y] = new Cell();
//				tempBoard[x][y].setUpperLeft(tempBoard[x-1][y-1]);
//				tempBoard[x][y].setUpper(tempBoard[x][y-1]);
//				tempBoard[x][y].setUpperRight(tempBoard[x+1][y-1]);
//				tempBoard[x][y].setLeft(tempBoard[x-1][y]);
//				tempBoard[x][y].setRight(tempBoard[x-1][y]);
//				tempBoard[x][y].setLowerLeft(tempBoard[x-1][y+1]);
//				tempBoard[x][y].setLower(tempBoard[x][y+1]);
//				tempBoard[x][y].setLowerRight(tempBoard[x+1][y+1]);
//			}
//		}
//		// link the upper left corner
//		tempBoard[0][0] = new Cell();
//		tempBoard[0][0].setRight(tempBoard[0][1]);
//		tempBoard[0][0].setLower(tempBoard[1][0]);
//		tempBoard[0][0].setLowerRight(tempBoard[1][1]);
//		// link the upper right corner
//		tempBoard[0][width-1] = new Cell();
//		tempBoard[0][width-1].setLeft(tempBoard[0][width-2]);
//		tempBoard[0][width-1].setLower(tempBoard[1][width-1]);
//		tempBoard[0][width-1].setLowerLeft(tempBoard[1][width-2]);
//		// link the lower left corner
//		tempBoard[height-1][0] = new Cell();
//		tempBoard[height-1][0].setRight(tempBoard[height-1][1]);
//		tempBoard[height-1][0].setUpper(tempBoard[height-2][0]);
//		tempBoard[height-1][0].setUpperRight(tempBoard[height-2][1]);
//		// link the lower right corner
//		tempBoard[height-1][width-1] = new Cell();
//		tempBoard[height-1][width-1].setLeft(tempBoard[height-1][width-2]);
//		tempBoard[height-1][width-1].setUpper(tempBoard[height-2][width-1]);
//		tempBoard[height-1][width-1].setUpperLeft(tempBoard[height-2][width-2]);
//		
//		//link top and bottom rows
//		for(int x = 1; x < width-1; x++) {
//			tempBoard[0][x] = new Cell();
//			tempBoard[0][x].setLeft(tempBoard[0][x-1]);
//			tempBoard[0][x].setRight(tempBoard[0][x+1]);
//			tempBoard[0][x].setLowerLeft(tempBoard[1][x-1]);
//			tempBoard[0][x].setLower(tempBoard[1][x]);
//			tempBoard[0][x].setLowerRight(tempBoard[1][x+1]);
//			
//			tempBoard[height-1][x] = new Cell();
//			tempBoard[height-1][x].setLeft(tempBoard[height-1][x-1]);
//			tempBoard[height-1][x].setRight(tempBoard[height-1][x+1]);
//			tempBoard[height-1][x].setUpperLeft(tempBoard[height-2][x-1]);
//			tempBoard[height-1][x].setUpper(tempBoard[height-2][x]);
//			tempBoard[height-1][x].setUpperRight(tempBoard[height-2][x+1]);
//		}
//		
//		//link left and right columns
//		for(int y = 1; y < height-1; y++) {
//			tempBoard[y][0].setUpper(tempBoard[y-1][0]);
//			tempBoard[y][0].setUpperRight(tempBoard[y-1][1]);
//			tempBoard[y][0].setRight(tempBoard[y][1]);
//			tempBoard[y][0].setLowerRight(tempBoard[y+1][1]);
//			tempBoard[y][0].setLower(tempBoard[y+1][0]);
//			
//			tempBoard[y][width-1].setUpper(tempBoard[y-1][width-1]);
//			tempBoard[y][width-1].setUpperLeft(tempBoard[y-1][width-2]);
//			tempBoard[y][width-1].setLeft(tempBoard[y][width-2]);
//			tempBoard[y][width-1].setLowerLeft(tempBoard[y+1][width-2]);
//			tempBoard[y][width-1].setLower(tempBoard[y+1][width-1]);
//		}
		
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

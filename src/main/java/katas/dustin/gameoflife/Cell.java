package katas.dustin.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	
	private boolean alive;
	private List<Cell> neighbors;
	
	public Cell() {
		this.alive = false;
		this.neighbors = new ArrayList<Cell>();
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public List<Cell> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Cell neighbor) {
		this.neighbors.add(neighbor);
	}
	
}

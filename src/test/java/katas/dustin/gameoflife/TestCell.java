package katas.dustin.gameoflife;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestCell {
	
	@Test
	public void defaultStateOfCellIsDead() {
		assertThat( new Cell().isAlive(), is(false));
	}
	
	@Test
	public void startsOutWithNoNeighbors() {
		assertThat(new Cell().getNeighbors().size(), is(0));
	}
	
	@Test
	public void addNeighborAddsACellToTheCurrentCellsListOfNeighbors() {
		Cell thisCell = new Cell();
		Cell thatCell = new Cell();
		
		thisCell.addNeighbor(thatCell);
		assertThat(thisCell.getNeighbors(), hasItem(thatCell));
	}

}

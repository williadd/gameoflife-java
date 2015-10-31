package katas.dustin.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestBoard {
	
	@Test
	public void getLiveNighborCountCountsAllLiveHorVertDiagNeighbors() {
		Board board = new Board(3, 3);
		
		char[][] state = new char[][] {
				{'.', '.', '.'},
				{'A', 'A', '.'},
				{'A', 'A', 'A'}
		};
		board.setBoard(state);
		
		assertEquals(2, board.getLiveNighborCount(0,0));
		assertEquals(2, board.getLiveNighborCount(0,1));
		assertEquals(1, board.getLiveNighborCount(0,2));
		assertEquals(3, board.getLiveNighborCount(1,0));
		assertEquals(4, board.getLiveNighborCount(1,1));
		assertEquals(3, board.getLiveNighborCount(1,2));
		assertEquals(3, board.getLiveNighborCount(2,0));
		assertEquals(4, board.getLiveNighborCount(2,1));
		assertEquals(2, board.getLiveNighborCount(2,2));
	}
	

}

package katas.dustin;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameOfLife {

	@Test
	public void gameIsInitializedWith_8By6_DefaultBoardSize() {
		GameOfLife game = new GameOfLife();
		assertEquals(8, game.getBoard().getWidth());
		assertEquals(6, game.getBoard().getHeight());
	}

}

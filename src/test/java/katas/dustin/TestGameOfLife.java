package katas.dustin;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestGameOfLife {

	@Test
	public void gameIsInitializedWith_8By6_DefaultBoardSize() {
		GameOfLife game = new GameOfLife();
		assertThat(game.getBoard().getWidth(), equalTo(8));
		assertThat(game.getBoard().getHeight(), equalTo(6));
	}
	
	@Test
	public void gameAllowsSettingArbitraryBoardState() {
		GameOfLife game = new GameOfLife();
		int[][] newState = new int[][] {
				{'.', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'A', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'.', 'A', '.', '.', 'A', 'A', 'A', 'A'},
				{'.', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'.', '.', 'A', '.', 'A', '.', 'A', '.'},
				{'A', 'A', '.', 'A', '.', 'A', '.', '.'}
		};
		game.setState(newState);
		int[][] updatedState = game.getState();
		
		for(int i = 0; i < newState.length; i++) {
			assertThat(updatedState[i], equalTo(newState[i]));
		}
	}

}

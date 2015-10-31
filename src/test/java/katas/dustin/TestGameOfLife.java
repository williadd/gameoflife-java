package katas.dustin;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
		char[][] newState = new char[][] {
				{'.', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'A', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'.', 'A', '.', '.', 'A', 'A', 'A', 'A'},
				{'.', '.', 'A', '.', 'A', 'A', '.', 'A'},
				{'.', '.', 'A', '.', 'A', '.', 'A', '.'},
				{'A', 'A', '.', 'A', '.', 'A', '.', '.'}
		};
		game.setState(newState);
		char[][] updatedState = game.getState();
		
		for(int i = 0; i < newState.length; i++) {
			assertThat(updatedState[i], equalTo(newState[i]));
		}
	}
	
	@Test
	public void cellDiesWhenFewerThan2LiveNeighbors() {
		GameOfLife game = new GameOfLife();
		char[][] newState = new char[][] {
				{'A', '.', 'A', 'A', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.'}
		};
		
		game.setState(newState);
		assertThat(game.nextStateOf(0,0), is('.'));
		assertThat(game.nextStateOf(0,2), is('.'));
		assertThat(game.nextStateOf(0,3), is('.'));
		assertThat(game.nextStateOf(2,1), is('.'));
		assertThat(game.nextStateOf(2,3), is('.'));
		assertThat(game.nextStateOf(3,1), is('.'));
		assertThat(game.nextStateOf(3,3), is('.'));
	}

}

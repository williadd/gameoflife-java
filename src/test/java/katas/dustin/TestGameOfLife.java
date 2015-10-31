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
	public void liveCellDiesWhenFewerThan2LiveNeighbors() {
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
	
	@Test
	public void liveCellDiesWhenMoreThan3LiveNeighbors() {
		GameOfLife game = new GameOfLife();
		char[][] newState = new char[][] {
				{'A', 'A', 'A', 'A', '.', '.', '.', '.'},
				{'A', 'A', '.', '.', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', 'A', 'A', 'A'},
				{'.', '.', '.', '.', '.', 'A', 'A', 'A'},
				{'.', '.', '.', '.', '.', 'A', 'A', 'A'}
		};
		
		game.setState(newState);
		assertThat(game.nextStateOf(0,1), is('.'));
		assertThat(game.nextStateOf(1,1), is('.'));
		assertThat(game.nextStateOf(4,6), is('.'));
	}
	
	@Test
	public void liveCellLivesWhen2Or3LiveNeighbors() {
		GameOfLife game = new GameOfLife();
		char[][] newState = new char[][] {
				{'A', 'A', 'A', 'A', '.', '.', '.', 'A'},
				{'A', 'A', '.', '.', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', 'A', 'A', 'A'},
				{'.', '.', '.', 'A', '.', 'A', 'A', 'A'},
				{'.', '.', '.', '.', '.', 'A', 'A', 'A'}
		};
		
		game.setState(newState);
		assertThat(game.nextStateOf(3,3), is('A'));
		assertThat(game.nextStateOf(3,5), is('A'));
	}
	
	@Test
	public void deadCellBecomesAliveWhenExactly3NeighborsAreAlive() {
		GameOfLife game = new GameOfLife();
		char[][] newState = new char[][] {
				{'A', 'A', 'A', 'A', '.', '.', '.', 'A'},
				{'A', 'A', '.', '.', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', 'A', 'A', 'A'},
				{'.', '.', '.', 'A', '.', 'A', 'A', 'A'},
				{'.', '.', '.', '.', '.', 'A', 'A', 'A'}
		};
		
		game.setState(newState);
		assertThat(game.nextStateOf(1,3), is('A'));
		assertThat(game.nextStateOf(2,6), is('A'));
		assertThat(game.nextStateOf(0,6), is('.'));
		assertThat(game.nextStateOf(1,2), is('.'));
	}
	
	@Test
	public void processesTheBoardLeftToRightTopToBottomToGetANewBoardState() {
		GameOfLife game = new GameOfLife();
		char[][] newState = new char[][] {
				{'A', 'A', 'A', 'A', '.', '.', '.', 'A'},
				{'A', 'A', '.', '.', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', '.', '.', '.'},
				{'.', 'A', '.', 'A', '.', 'A', 'A', 'A'},
				{'.', '.', '.', 'A', '.', 'A', 'A', 'A'},
				{'.', '.', '.', '.', '.', 'A', 'A', 'A'}
		};
		
		game.setState(newState);
		game.processSingleLifeCycle();
		char[][] expectedState = new char[][] {
				{'A', '.', 'A', '.', '.', '.', '.', '.'},
				{'A', '.', 'A', 'A', '.', '.', '.', '.'},
				{'A', '.', '.', 'A', '.', '.', 'A', 'A'},
				{'.', '.', 'A', 'A', '.', '.', '.', '.'},
				{'.', '.', 'A', 'A', '.', 'A', '.', 'A'},
				{'.', '.', '.', '.', 'A', 'A', '.', '.'}
		};
		assertThat(game.getState(), equalTo(expectedState));
	}

}

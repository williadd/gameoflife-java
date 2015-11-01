# gameoflife-java

Overall solution is based on an object oriented solution to the problem: a game, a game woth a board, and a board with cells. The cells know there state and their nighbors. The board knows all of the cells, and the game controls the rules of the game.

## Building the Solution
The project is mavenized using Maven 3.

## Running the solution

### Running as described in the kata

The solution comes with a [JSON file](./data/grid.json) containing a grid. This file can be used to specify an arbitrary starting state for the game.

<code>
mvn package exec:java -Dexec.mainClass="katas.dustin.GameOfLifeKata"
</code>

will promt you for a file. The file should be JSON with an 8x6 grid. The application will show the state loaded from the file and will process one generation of the game, and then print the result.

### Running the game for a specified number of generations

In this mode the application will use a starting state defined in the main class. You will be asked for the number of generations to run. Note that the appl will not stop if all cells die, it will continue to process the number of generations you specify.

<code>
mvn package exec:java -Dexec.mainClass="katas.dustin.GameOfLifeAutoRun"
</code>

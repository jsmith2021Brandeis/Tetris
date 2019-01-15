package PlayGame;

import GUI.Interface;
import HighScore.ScoreKeeper;
import Navigation.Direction;
import Navigation.Mover;
import Pieces.PieceName;

/**
 * Name: Jacob Smith Email:jsmith2021@brandeis.edu Date: Dec 19, 2018December 19
 * 2018 Assignment: Personal Study, plays a game of tetris Bugs:
 * https://teamtreehouse.com/community/is-it-possible-to-clear-the-console-during-execution-in-a-java-workspace
 * for clear command
 * https://www.darkcoding.net/software/non-blocking-console-io-is-not-possible/
 * for random start
 * https://www.geeksforgeeks.org/java-math-random-method-examples/ I've
 * completely encapsulated how to output! The game class has no idea how to do
 * it!
 */

public class Game {

	private Board board;
	private PieceName[] pieceNames;
	Timer timer;
	private Interface display;
	private int interval;
	private int numPieces;
	String toOutput;
	ScoreKeeper highScores;
	//increases score for every time user moves down, doesn't rely on computer preformance,
	//becuase it isn't calculated with actual time
	private int timeBonus;

	/**
	 * Creates a new Game object
	 * 
	 * @param display
	 *            the Output object that specifies how to print the board
	 */
	public Game(Interface display) {
		board = new Board();
		timer = new Timer();
		pieceNames = PieceName.values();
		this.display = display;
		interval=150;
		numPieces=30;
		timeBonus=0;;
		toOutput="";
	}

	/**
	 * plays a game of Tetris
	 * 
	 * @return whether the player won or lost
	 */
	public boolean playGame() {
		displayWelcomeMessage();
		Timer gameTimer=new Timer();
		for (int i = 0; i < numPieces; i++) {
			toOutput="Pieces Left:"+(numPieces-i)+"\n";
			Mover m = getPiece();
			moveDown(m);

		}
		displayFinalMessage(gameTimer);
		// once game is over, reset for new game
		board = new Board();
		return false;

	}
	
	/**
	 * displays a welcome message and controls
	 */
	private void displayWelcomeMessage() {
		String welcome="Welcome to the Tetris Game\n"+
		"Here are the controls:\n"+
		"A:LEFT\n"+
		"S:DOWN\n"+
		"D:RIGHT\n"+
		"W:ROTATE\n";
		display.output(welcome);
		//wait 5 seconds
		while(!timer.elapsed(2000)) {}
	}
	
	/**
	 * Puts a thank you message along with the final score on the display
	 * @param gameTimer a timer object that holds how long the game took
	 */
	private void displayFinalMessage(Timer gameTimer) {
		highScores=new ScoreKeeper(2);
		String finalMessage="Thanks for Playing!\nInitial Score  Was "+board.getScore()+"\n";
		finalMessage+="Plus time bonus "+timeBonus+"\n";
		int finalScore=timeBonus+board.getScore();
		finalMessage+="Final score of "+finalScore;
		display.output(finalMessage);
		while(!timer.elapsed(2000)) {}
		//add the game score to list of highscores and display Them
		highScores.addHighScore("TEST", timeBonus+board.getScore());
		display.output("HIGHSCORES ON TETRIS\n"+highScores.getHighScores());
		highScores.writeToFile();
		while(!timer.elapsed(2000)) {}
	}

	/**
	 * Advances a mover down the board
	 * 
	 * @param m
	 *            the mover to advance
	 */
	private void moveDown(Mover m) {
		//the number of times the piece failed to move down, to give some
		//latency allowing the user to slide a piece sideways
		int numFailed=0;
		while (numFailed<3) {
			// wait for a specified time
			while (!timer.elapsed(interval)) {
				// if the user presses a key associated with a direction
				Direction d = display.input();
				if (d != null) {
					// move the piece in that direction and display result
					board.movePiece(m, d);
					if(d.equals(Direction.DOWN)) {
						timeBonus+=1;
					}
					display.output(board.toString(true)+toOutput);
					
				}
			}
			// move the piece down
			boolean didMove = board.movePiece(m, Direction.DOWN);
			// display the board
			display.output(board.toString(true)+toOutput);
			if(!didMove) {
				numFailed++;
			}
		}

	}

	/**
	 * creates a random mover at random starting column and returns it
	 * 
	 * @return a random mover
	 */
	private Mover getPiece() {
		// get random piece Name
		int index = (int) (Math.random() * pieceNames.length);
		PieceName p = pieceNames[index];
		// get random column
		int width = board.getWidth();
		//should be -4, changed for testing
		int maxColumn = width;
		int column = (int) (Math.random() * maxColumn);

		// create and return a mover with that name and column start
		Mover m = new Mover(p, column);
		return m;

	}

}

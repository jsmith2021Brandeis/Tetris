package testPlayGame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Navigation.Direction;
import Navigation.Mover;
import Pieces.PieceName;
import PlayGame.Board;

/**
 * Name: Jacob Smith Email:jsmith2021@brandeis.edu Date: Dec 19, 2018December 19
 * 2018 Assignment: Personal Study, tests the Board class of my Tetris project
 * Bugs: for some reason to string is differen from implicit method call?
 * 	advance is very simmilar o testMover move method, maybe board should have all possible movers?
 */

public class testBoard  {
	private Board board;

	@Before
	public void setup() {
		board = new Board();

	}

	/**
	 * asserts that default length of board is 20
	 */
	@Test
	public void testGetLength() {

		assertEquals(20, board.getLength());
	}

	/**
	 * asserts that default width of board is 10
	 */
	@Test
	public void testGetWidth() {

		assertEquals(10, board.getWidth());
	}
	

	/**
	 * Places 4 tetris pieces on bottom of board, asserting thier final position
	 * and assserting that board clears automatically at end
	 * @return whether the player won or lost
	 */
	@Test
	public void testTetrisSequence() {

			Mover m = new Mover(PieceName.LONGPIECE, 0);
			board.placePiece(m);
			advance(Direction.DOWN, m);
			m = new Mover(PieceName.SNAKEPIECE, 3);
			board.placePiece(m);
			advance(Direction.DOWN, m);
			m = new Mover(PieceName.SQUARE, 6);
			board.placePiece(m);
			advance(Direction.DOWN, m);
			m = new Mover(PieceName.SQUARE, 8);
			board.placePiece(m);
			advance(Direction.DOWN, m);
			String correctBoard=
							" ____________________\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|                    |\n"+
							"|      [][]  [][][][]|\n"+
							" ____________________\n";
			assertEquals(correctBoard,board.toString());
	}
	
	/**
	 * moves a piece in that direction until it stops
	 * @param dir the direction the piece will move
	 * @param m the Mover to advance
	 */
	public void advance(Direction dir,Mover m) {
		boolean didMove=true;
		while(didMove) {
			didMove=board.movePiece(m, dir);
		}
	}

	

	

	/**
	 * checks to make sure that the blank board is printed correctly
	 */
	@Test
	public void testPrintBoard() {
		Board b = new Board();
		String correctBoard = " ____________________\n" + "|                    |\n" + "|                    |\n"
				+ "|                    |\n" + "|                    |\n" + "|                    |\n"
				+ "|                    |\n" + "|                    |\n" + "|                    |\n"
				+ "|                    |\n" + "|                    |\n" + "|                    |\n"
				+ "|                    |\n" + "|                    |\n" + "|                    |\n"
				+ "|                    |\n" + "|                    |\n" + "|                    |\n"
				+ "|                    |\n" + "|                    |\n" + "|                    |\n"
				+ " ____________________\n";
		assertEquals(correctBoard, b.toString());

	}
}

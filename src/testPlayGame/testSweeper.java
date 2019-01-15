/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 24, 2018
  *Assignment:	Personal Study, provides methods to test the Sweeper class of my Tetris project
  *Bugs:
  */
package testPlayGame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import PlayGame.Sweeper;
import testNavigation.genGrids;

public class testSweeper {
	boolean[][]board;
	
	/**
	 * Uses sample board to make sure double tetris is cleared to blank board
	 */
	@Test
	public void testClearRow() {
		board=genGrids.createPartiallyFilledBoardVert();
		Sweeper.clearTetris(board);
		String correctString=
			"        \n"+
		    "        \n"+
		    "        \n"+
		    "        \n";
		assertEquals(correctString,genGrids.ArrtoString(board));
	}
	
	/**
	 * Uses sample board to make sure row is cleared and block drops down
	 */
	@Test
	public void testClearRowOnePieceLeft() {
		board=genGrids.createInverse();
		board[3][3]=true;
		//board is now
		/**
		 * 
		 * 
		 *   []
		 * [][][][]
		 */
		Sweeper.clearTetris(board);
		String correctString=
			"        \n"+
		    "        \n"+
		    "        \n"+
		    "  []    \n";
		assertEquals(correctString,genGrids.ArrtoString(board));
	}
	
	/**
	 * Uses sample board to make sure full board becomes empty
	 */
	@Test
	public void testFull() {
		board=genGrids.createFull();
		Sweeper.clearTetris(board);
		String correctString=
			"        \n"+
		    "        \n"+
		    "        \n"+
		    "        \n";
		assertEquals(correctString,genGrids.ArrtoString(board));
	}
	
	
	/**
	 * Uses sample board to make sure incomplete board is left alone
	 */
	@Test
	public void testShouldntClear() {
		board=genGrids.createPartiallyFilledBoardHoriz();
		Sweeper.clearTetris(board);
		String correctString=
			"    [][]\n"+
		    "    [][]\n"+
		    "    [][]\n"+
		    "    [][]\n";
		assertEquals(correctString,genGrids.ArrtoString(board));
	}
}

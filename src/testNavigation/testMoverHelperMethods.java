/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 19, 2018December 19 2018
  *Assignment:	Personal Study, tests the nonMove methods of Mover class of my Tetris project
  *Bugs:
  *canMove, move
  */
package testNavigation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Navigation.Mover;
import Pieces.PieceName;

public class testMoverHelperMethods {
	
	Mover m;

	/**
	 * starts test suite with blank board and piece
	 */
	@Before
	public void setup() {
		m = new Mover(PieceName.SQUARE);
	}

	/**
	 * tests the getRow method of the Mover class
	 */
	@Test
	public void testGetRow() {
		
		int row=m.getRow();
		assertEquals(-1,row);
		
	}
	
	
	/**
	 * tests the getCol method of the Mover class
	 */
	@Test
	public void testGetCol() {
		
		int row=m.getCol();
		assertEquals(0,row);
		
	}
	
	/**
	 * asserts that the piece can be placed on empty board
	 * and checks empty board
	 */
	@Test
	public void testPlaceEmptyBoard (){
		boolean [][]board=genGrids.createBlankBoard();
		boolean didPlace=m.place(board);
		assertEquals(true,didPlace);
		String correctBoard=
			"[][]    \n"+
			"[][]    \n"+
			"        \n"+
			"        \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
	}
	
	/**
	 * asserts that the piece can't be placed on full board and checks to make sure board wasn't modified
	 */
	@Test
	public void testPlaceFullBoard (){
		boolean [][]board=genGrids.createFull();
		boolean didPlace=m.place(board);
		assertEquals(false,didPlace);
		String correctBoard=
			"[][][][]\n"+
			"[][][][]\n"+
			"[][][][]\n"+
			"[][][][]\n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
	}


}

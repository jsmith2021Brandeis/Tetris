/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 24, 2018
  *Assignment:	
  *Bugs:
  */
package testNavigation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Navigation.Direction;
import Navigation.Mover;
import Pieces.PieceName;

public class testMoverMoveMethod {
	boolean [][] board;
	Mover m;

	/**
	 * starts test suite with blank board and square
	 */
	@Before
	public void setup() {
		m = new Mover(PieceName.SQUARE);
		board=genGrids.createBlankBoard();
	}
	
	/**
	 * tests that the reverse l piece can get to the bottom of blank board, checking every move
	 *@param p the name of the piece
	 *@param lastRow the row the piece should stop at
	 *@param col the column to start the piece at
	 */
	public void putPieceOnBottom(PieceName p,int lastRow,int col) {
		
		m=new Mover(p,col);
		//place piece
		m.place(board);
		//assert that L piece stops at row 2
		advance(lastRow,col,Direction.DOWN);	
	}
	
	
	/**
	 * moves the reverse l and sqaure pieces down the board, asserting where each piece stops and how the board
	 * looks
	 */
	@Test
	public void testMoveDownTwoPieces() {

		putPieceOnBottom(PieceName.LPIECEBACKWARD,2,0);
		//assert that board looks like this:
		String correctBoard=
				"        \n"+
				"        \n"+
				"    []  \n"+
				"[][][]  \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
		//create and place square
		putPieceOnBottom(PieceName.SQUARE,1,0);
		//assert that board looks like this:
		correctBoard=
						"        \n"+
						"[][]    \n"+
						"[][][]  \n"+
						"[][][]  \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
	}
	
	/**
	 * Moves L piece down and to right, then moves square piece down and two right
	 * after every move, we assert whether the piece moved and we also assert the state of the board after every
	 * set of moves
	 */
	@Test
	public void testMoveDownRightTwoPieces() {
		
		putPieceOnBottom(PieceName.LPIECEBACKWARD,2,0);
		//assert that board looks like this:
		String correctBoard=
				"        \n"+
				"        \n"+
				"    []  \n"+
				"[][][]  \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
		//make sure L piece stops at col 1
		advance(2,1,Direction.RIGHT);
		correctBoard=
				"        \n"+
				"        \n"+
				"      []\n"+
				"  [][][]\n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
	
		//put square on bottom and assert board looks like this
		this.putPieceOnBottom(PieceName.SQUARE, 1, 0);
		correctBoard=
				"        \n"+
				"[][]    \n"+
				"[][]  []\n"+
				"  [][][]\n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
		
		//assert square piece stops at col 1 and board looks like this
		advance(1,1,Direction.RIGHT);
		//assert that board looks like this:
		correctBoard=
				"        \n"+
				"  [][]  \n"+
				"  [][][]\n"+
				"  [][][]\n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
	}
	/**
	 * Moves L piece down and to left, then moves square piece down and two right
	 * after every move, we assert whether the piece moved and we also assert the state of the board after every
	 * set of moves
	 */
	@Test
	public void testMoveDownLeftTwoPieces() {
		putPieceOnBottom(PieceName.LPIECE,2,1);
		//assert that board looks like this:
		String correctBoard=
				"        \n"+
				"        \n"+
				"  []    \n"+
				"  [][][]\n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
		//make sure L piece stops at col 0 and board looks like this 
		advance(2,0,Direction.LEFT);
		correctBoard=
				"        \n"+
				"        \n"+
				"[]      \n"+
				"[][][]  \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
	
		//put square on bottom and assert board looks like this
		this.putPieceOnBottom(PieceName.SQUARE, 1, 2);
		correctBoard=
				"        \n"+
				"    [][]\n"+
				"[]  [][]\n"+
				"[][][]  \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
		
		//move square to right and assert board looks like this
		advance(1,1,Direction.LEFT);
		//assert that board looks like this:
		correctBoard=
				"        \n"+
				"  [][]  \n"+
				"[][][]  \n"+
				"[][][]  \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
	}
	
	/**
	 * Moves the L piece down and rotates it
	 */
	@Test
	public void testMoveDownandRotate() {
		m=new Mover(PieceName.LONGPIECE);
		m.place(board);
		//assert that board looks like this:
		String correctBoard=
				"[][][][]\n"+
				"        \n"+
				"        \n"+
				"        \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
		//rotate piece
		m.move(board, Direction.ROTATELEFT);
		//assert that board looks like this:
		correctBoard=
						"[]      \n"+
						"[]      \n"+
						"[]      \n"+
						"[]      \n";
		assertEquals(correctBoard,genGrids.ArrtoString(board));
	}
	
	
	/**
	 * helper method to save having to pass board and mover in this class
	 * asserts where the piece stops when it moves in given direction
	 * @param lastRow the last row the piece can move to
	 * @param lastCol the last Column the piece can move to
	 * @param dir the direction the piece will move
	 */
	public void advance(int lastRow,int lastCol,Direction dir) {
		advance(lastRow,lastCol,dir,m,board);
	}
	
	/**
	 * asserts where the piece stops when it moves in given direction
	 * @param lastRow the last row the piece can move to
	 * @param lastCol the last Column the piece can move to
	 * @param dir the direction the piece will move
	 * @param m the Mover to advance
	 * @param board the board to advance across
	 */
	public static void advance(int lastRow,int lastCol,Direction dir,Mover m,boolean[][]board) {
		
		//keeps moving as long as row and column aren't reached
		//the size of the board stops this from getting out of control
		while(m.getRow()!=lastRow || m.getCol()!=lastCol) {
			boolean didMove = m.move(board, dir);
			assertEquals(true, didMove);
		}
		//at row n+1, piece can't move anymore
		boolean didMove = m.move(board, dir);
		assertEquals(false, didMove);
	}

}

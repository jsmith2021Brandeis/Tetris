/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 20, 2018
  *Assignment: Personal Study, tests the Placer class using sample grids
  *Bugs:
  */
package testNavigation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Navigation.Placer;
import Pieces.GamePiece;
import Pieces.PieceName;

public class testPlacer {

	/**
	 * tests whether the placer throws any exceptions when navigating the edge of
	 * the board board
	 * 
	 */
	@Test
	public void testPlacerException() {
		boolean[][] board = genGrids.createBlankBoard();
		boolean[][] pieceMap = genGrids.createPieceMap();
		Placer p = new Placer();

		boolean threwException=false;
		try {
			p.boardTraverse(0, board[0].length-4, pieceMap, board, true);
		} catch (Exception e) {
			threwException=true;
		}

		assertEquals(false, threwException);

	}

	/**
	 * tests whether the board looks like this after inserting tri block to empty
	 * board
	 */
	@Test
	public void testPlacerBlankBoard() {
		boolean[][] board = genGrids.createBlankBoard();
		boolean[][] pieceMap = genGrids.createPieceMap();
		Placer p = new Placer();

		p.boardTraverse(0, 0, pieceMap, board, true);
		String correctBoard = "  []    \n" + "[][][]  \n" + "        \n" + "        \n";
		assertEquals(correctBoard, genGrids.ArrtoString(board));

	}

	/**
	 * tests whether the board looks like this after inserting into a partially
	 * filled board
	 */
	@Test
	public void testPlacerInverse() {
		boolean[][] board = genGrids.createInverse();
		GamePiece triBlock = new GamePiece(PieceName.TRIBLOCK);
		triBlock.rotateRight();
		boolean[][] pieceMap = triBlock.getPieceMap();

		Placer p = new Placer();

		p.boardTraverse(0, 0, pieceMap, board, true);
		String correctBoard = 
				"    []  \n" +
				"    [][]\n" + 
				"  [][]  \n" +
				"[][][]  \n";
		assertEquals(correctBoard, genGrids.ArrtoString(board));

	}

	/**
	 * tests whether eraser successfully makes the board blank
	 */
	@Test
	public void testErasingInverse() {
		boolean[][] board = genGrids.createInverse();
		GamePiece triBlock = new GamePiece(PieceName.TRIBLOCK);
		boolean[][] pieceMap = triBlock.getPieceMap();

		Placer p = new Placer();

		p.boardTraverse(2, 0, pieceMap, board, false);
		String correctBoard = "        \n" + "        \n" + "        \n" + "        \n";
		assertEquals(correctBoard, genGrids.ArrtoString(board));

	}

	/**
	 * tests whether eraser successfully makes the board blank only in the correct
	 * location
	 */
	@Test
	public void testErasingFulBoard() {
		boolean[][] board = genGrids.createFull();
		GamePiece triBlock = new GamePiece(PieceName.TRIBLOCK);
		boolean[][] pieceMap = triBlock.getPieceMap();

		Placer p = new Placer();

		p.boardTraverse(0, 0, pieceMap, board, false);
		String correctBoard = 
				"[]  [][]\n" +
				"      []\n" + 
				"[][][][]\n" +
				"[][][][]\n";
		assertEquals(correctBoard, genGrids.ArrtoString(board));

	}

}

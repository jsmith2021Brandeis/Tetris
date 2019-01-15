/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 20, 2018
  *Assignment: Personal Study, tests the Checker class of my tetris project	
  *Bugs: because I define tetris piece as lower left corner of box, indexing gets weird
  *I could use array visualizer from checker to make this more readable...
  */
package testNavigation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Navigation.Checker;
import Pieces.GamePiece;
import Pieces.PieceName;

public class testChecker {

	/**
	 * tests whether the piece overlaps with different locations of a blank board going up and down
	 */
	@Test
	public void testCheckingBlankBoardVert() {
		boolean[][]board=genGrids.createBlankBoard();
		boolean[][]pieceMap=genGrids.createPieceMap();
		Checker c=new Checker();
		
		//no overlap, should return true because piece can move there
		for(int vertOffset=0;vertOffset<3;vertOffset++) {
			
			boolean result1=c.boardTraverse(vertOffset, 0, pieceMap, board,false);
			assertEquals(true,result1);
		}
	
		//there should be overlap, should return false because piece can't move there
		boolean result2=c.boardTraverse(3, 0, pieceMap, board,false);
		assertEquals(false,result2);
	
	}
	
	/**
	 * tests whether the piece overlaps with different locations of a blank board going left and right
	 */
	@Test
	public void testCheckingBlankBoardHoriz() {
		boolean[][]board=genGrids.createBlankBoard();
		boolean[][]pieceMap=genGrids.createPieceMap();
		Checker c=new Checker();
		
		//no overlap, should return true because piece can move there
		for(int horizOffset=0;horizOffset<2;horizOffset++) {
			
			boolean result1=c.boardTraverse(0, horizOffset, pieceMap, board,false);
			assertEquals(true,result1);
		}
		
		//there should be overlap, should return false because piece can't move there
		for(int horizOffset=2;horizOffset<board[0].length;horizOffset++) {
					
			boolean result1=c.boardTraverse(0, horizOffset, pieceMap, board,false);
			assertEquals(false,result1);
		}
	
	}
	
	/**
	 * tests whether the piece overlaps with different locations of a partially filled board going up and down
	 */
	@Test
	public void testCheckingPartiallyFilledBoardVert() {
		boolean[][]board=genGrids.createPartiallyFilledBoardVert();
		boolean[][]pieceMap=genGrids.createPieceMap();
		Checker c=new Checker();
		
		//only first position should work
		for(int vertOffset=0;vertOffset<1;vertOffset++) {
			boolean result=c.boardTraverse(vertOffset, 0, pieceMap, board,false);
			assertEquals(true,result);
		}
		
		//the next positions should not be a match
		for(int vertOffset=1;vertOffset<board.length;vertOffset++) {
			boolean result=c.boardTraverse(vertOffset, 0, pieceMap, board,false);
			assertEquals(false,result);
		}
		

	}
	
	/**
	 * tests whether the piece overlaps with different locations of a partially filled board going left and right
	 */
	@Test
	public void testCheckingPartiallyFilledBoardHoriz() {
		boolean[][]board=genGrids.createPartiallyFilledBoardHoriz();
		boolean[][]pieceMap=genGrids.createPieceMap();
		Checker c=new Checker();
		
		//all positions should fail
		for(int horizOffset=0;horizOffset<board[0].length;horizOffset++) {
			boolean result=c.boardTraverse(0, horizOffset, pieceMap, board,false);
			assertEquals(false,result);
		}

	}
	
	/**
	 * tests whether the piece overlaps with a board in the inverse of its shape
	 * it shouldn't
	 * remember that becuase the shape was rotated, it is in the top corner of its box
	 */
	@Test
	public void testCheckingInverse() {
		boolean[][]board=genGrids.createInverse();
		GamePiece g=new GamePiece(PieceName.TRIBLOCK);
		g.rotateRight();
		boolean[][]pieceMap=g.getPieceMap();
		Checker c=new Checker();
		
		//this should fail because the piece is now three high and top blocks are out of board
		for(int vertOffset=-2;vertOffset<0;vertOffset++) {
		
			boolean result1=c.boardTraverse(vertOffset, 0, pieceMap, board,false);
			assertEquals(false,result1);
			
		}
			
		//this is the only position that should work
		boolean result2=c.boardTraverse(0, 0, pieceMap, board,false);
		assertEquals(true,result2);
		
		
		//the next positions should not be a match
		for(int vertOffset=1;vertOffset<board.length;vertOffset++) {
			boolean result3=c.boardTraverse(vertOffset, 0, pieceMap, board,false);
			assertEquals(false,result3);
		}
		

	}
	
	
}

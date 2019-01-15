/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 20, 2018December 19 2018
  *Assignment:	Personal Study, tests the PieceNam enum by mathcing piece names to their strings
  *Bugs:
  */
package testPieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Pieces.PieceName;

public class testPieceName {
	
	@Test
	/**
	 * makes sure the triblock enum has correct string map
	 */
	public void testTriBlock() {
		
		 testEnum(PieceName.TRIBLOCK,"01001110");
	}
	
	@Test
	/**
	 * makes sure the long piece enum has correct string map
	 */
	public void testLongPiece() {
		
		testEnum(PieceName.LONGPIECE,"11110000");
	
	}
	
	@Test
	/**
	 * makes sure the sqaure piece enum has correct string map
	 */
	public void testSquarePiece() {
		
		testEnum(PieceName.SQUARE,"11001100");
		
	}
	
	@Test
	/**
	 * makes sure the L piece
	 */
	public void testLPiece() {
		
		testEnum(PieceName.LPIECE,"10001110");
		
	}

	@Test
	/**
	 * makes sure the L piece bakcward enum has correct string map
	 * 	 */
	public void testLPieceBackward() {
		
		testEnum(PieceName.LPIECEBACKWARD,"00101110");
		
	}
	
	@Test
	/**
	 * makes sure the snakePiece enum has correct string map
	 */
	public void testSnakePiece() {
		
		testEnum(PieceName.SNAKEPIECE,"11000110");
		
	}
	
	@Test
	/**
	 * makes sure the snakePieceBackward enum has correct string map
	 */
	public void testSnakePieceBackward() {
		
		testEnum(PieceName.SNAKEPIECEBACKWARD,"01101100");
		
	}

	/**
	 * Helper method to test PieceNames
	 * @param p the pieceNameto be tested
	 * @param correctCode the correct code of the pieceName
	 */
	private void testEnum(PieceName p, String correctCode) {
		String code=p.toString();
		assertEquals(correctCode,code);		
	}

}

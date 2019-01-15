package testPieces;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Pieces.GamePiece;
import Pieces.PieceName;


/**
 * Name: Jacob Smith Email:jsmith2021@brandeis.edu Date: Dec 19, 2018December 19
 * 2018 Assignment: personal study, runs Junit tests on testGamePiececlass Bugs:
 * 
 */

public class testGamePiece {


	/**
	 * creates piece objects using the strig representation and asserts that the
	 * piece's to String is the correct shape this is an aexmaple of encapsulation,
	 * I'm not checking the internal state of piece Object, just its toString
	 */
	@Test
	public void testConstructor() {

		GamePiece piece = new GamePiece(PieceName.TRIBLOCK);
		String correctPiece = 
				
				"  []    \n" +
				"[][][]  \n"+
				"        \n"+
				"        \n";
		assertEquals(correctPiece, piece.toString());

		piece = new GamePiece(PieceName.LONGPIECE);
		correctPiece =
				
				"[][][][]\n"+
				"        \n"+
				"        \n"+
				"        \n";
				
		assertEquals(correctPiece, piece.toString());

		piece = new GamePiece(PieceName.SNAKEPIECE);
		correctPiece =
				"[][]    \n" +
				"  [][]  \n"+
				"        \n"+
				"        \n";
				
		assertEquals(correctPiece, piece.toString());
	}
	
	@Test
	/**
	 *  tests the rotate right method by creating two piece objects, rotating them, and ensuring they havecorrect toStrings
	 */
	public void testRotateLeft() {
		//check tri Piece, rotating four times to get back to original
		GamePiece p=new GamePiece(PieceName.TRIBLOCK);

		p.rotateLeft();
		String correctPiece= 
				"        \n"+
				"  []    \n"+
				"[][]    \n"+
				"  []    \n";
			
		assertEquals(correctPiece,p.toString());
		
		p.rotateLeft();
		correctPiece= 
				"        \n"+
				"        \n"+
				"  [][][]\n"+
				"    []  \n";
				
		assertEquals(correctPiece,p.toString());
		
		p.rotateLeft();
		correctPiece= 
				
				"    []  \n"+
				"    [][]\n"+
				"    []  \n"+
				"        \n";

		assertEquals(correctPiece,p.toString());
		
		p.rotateLeft();
		correctPiece= 
				
				"  []    \n"+
				"[][][]  \n"+
				"        \n"+
				"        \n";
		assertEquals(correctPiece,p.toString());
		
		
		//check long piece
		p=new GamePiece(PieceName.LONGPIECE);
		
		p.rotateLeft();
		correctPiece= 
				"[]      \n"+
				"[]      \n"+
				"[]      \n"+
				"[]      \n";
		assertEquals(correctPiece,p.toString());
		
	
	}
	
	@Test
	/**
	 * tests the rotate right method by creating two piece objects, rotating them, and ensuring they havecorrect toStrings
	 */
	public void testRotateRight() {
		//check tri Piece, rotating four times to get back to original
		GamePiece p=new GamePiece(PieceName.TRIBLOCK);
		
		p.rotateRight();
		String correctPiece= 
				"    []  \n"+
				"    [][]\n"+
				"    []  \n"+
				"        \n";
		assertEquals(correctPiece,p.toString());
		
		p.rotateRight();
		correctPiece= 
				"        \n"+
				"        \n"+
				"  [][][]\n"+
				"    []  \n";
		assertEquals(correctPiece,p.toString());
		
		p.rotateRight();
		correctPiece= 
	
				"        \n"+
				"  []    \n"+
				"[][]    \n"+
				"  []    \n";
				
		assertEquals(correctPiece,p.toString());
		
	
		p.rotateRight();
		correctPiece= 
				
				"  []    \n"+
				"[][][]  \n"+
				"        \n"+
				"        \n";
		assertEquals(correctPiece,p.toString());
		
		
		//check long piece
		p=new GamePiece(PieceName.LONGPIECE);
	
		p.rotateRight();
		correctPiece= 
				"      []\n"+
				"      []\n"+
				"      []\n"+
				"      []\n";
		assertEquals(correctPiece,p.toString());
		
	
	}

}

/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 19, 2018December 19 2018
  *Assignment:	Personal Study, tests the Traverser class of my Tetris project
  *Bugs:

  */
package testNavigation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Navigation.Traverser;

public abstract class testTraverser extends Traverser {

	/**
	 * invokes super constructor to make a new testTraverse object for testing
	 * 
	 */
	public testTraverser() {
		super();
	}


	
	/**
	 * creates a sample grid and probes certain locations to see if they are in bounds
	 */
	@Test
	public void testInBounds() {
		boolean[][]grid=genGrids.createBlankBoard();
		boolean result1=Traverser.isInBounds(0, 0, grid);	
		assertEquals(true,result1);
		boolean result2=Traverser.isInBounds(-1, 0, grid);	
		assertEquals(false,result2);
		boolean result3=Traverser.isInBounds(0, 11, grid);	
		assertEquals(false,result3);
		
	}

	
	/**
	 * tests is Between method when it should return true and false
	 */
	@Test
	public void testIsBetween() {
		boolean result1 = Traverser.isBetween(2, 0, 4);
		assertEquals(true, result1);
		boolean result2 = Traverser.isBetween(5, 0, 4);
		assertEquals(false, result2);

	}

	@Test
	/**
	 * make sure that the is between method throws an exception when max is less than min
	 */
	public void testIsBetweenException() {
		boolean threwException =false;
		try {
			Traverser.isBetween(2, 3, 2);
		} catch (IllegalArgumentException e) {
			threwException=true;
		}
		assertEquals(true,threwException);
		

	}

}

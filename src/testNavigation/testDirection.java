/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 20, 2018
  *Assignment:	Personal Study, tests the strings of my direction enum
  *Bugs:
  */
package testNavigation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Navigation.Direction;

public class testDirection {

	
	/**
	 * makes sure the down direction is correct
	 */
	@Test
	public void testDown() {
		testEnum(Direction.DOWN,0,1);
	}
	
	
	/**
	 * makes sure the left direction is correct
	 */
	@Test
	public void testLeft() {
		testEnum(Direction.LEFT,-1,0);
	}
	
	
	/**
	 * makes sure the right direction is correct
	 */
	@Test
	public void testRight() {
		testEnum(Direction.RIGHT,1,0);
	}

	/**
	 * A helper method to test the direction enums
	 * @param d the Direction enum to test
	 * @param correctString the correct name of the direction
	 */
	public void testEnum(Direction d,int correctHorizOffset, int correctVertOffset) {
		assertEquals(d.getHorizOffset(),correctHorizOffset);
		assertEquals(d.getVertOffset(),correctVertOffset);
	}
}

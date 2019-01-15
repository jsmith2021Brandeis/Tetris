/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 27, 2018
  *Assignment:	Personal Study, tests the Linkedlist class with a before method to save code
  *		this should only be done after the testLinkedListnoDependency class
  *Bugs:
  */
package testHighScore;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import HighScore.LinkedList;

public class testLinkedListwithDependency {
	LinkedList<String> list;

	/**
	 * creates a linked list, performed every time
	 */
	@Before
	public void setup() {

		list = new LinkedList<>();
		list.insert("Jacob");
		list.insert("Samuel");
		list.insert("Susan");

	}

	/**
	 * inserts Tommy after samuel and ensures that list is correctly structured
	 * checks if data is inserted after Samuel
	 */
	@Test
	public void testInsertAfter() {
		list.insert("Tommy", "Samuel");
		String correctString = "Jacob--> Samuel--> Tommy--> Susan";
		assertEquals(correctString, list.toString());
	}
	
	/**
	 * ensures that the toString method allowing custom separators is corrct
	 */
	@Test
	public void testToString() {
		String correctString = "Jacob/nSamuel/nSusan";
		assertEquals(correctString, list.toString("/n"));

	}

	/**
	 * ensures that the toString method is correct which can also be used to check
	 * state of LinkedList
	 */
	@Test
	public void testToStringDefault() {
		String correctString = "Jacob--> Samuel--> Susan";
		assertEquals(correctString, list.toString());

	}
}

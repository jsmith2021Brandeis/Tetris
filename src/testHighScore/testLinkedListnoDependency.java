/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 27, 2018
  *Assignment:Personal Study, tests the Linked List class individually for the high scores of my tetris project
  *Bugs:
  */
package testHighScore;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import HighScore.LinkedList;

public class testLinkedListnoDependency {

	/**
	 * inserts bonny to list to see if insert method can handle when head is null
	 * and checks to see if the head is updated properly
	 */
	@Test
	public void testInsertasFirst() {
		LinkedList<String>list = new LinkedList<>();
		list.insert("Bonny");
		String correctString = "Bonny";
		assertEquals(correctString, list.toString());
		assertEquals(correctString,list.getHead().getData());
	}

	/**
	 * inserts bonny to list and then clyde and checks that list is correclty
	 * structured to see if insert inserts correctly at end of list
	 * and checks to see if the head is updated properly
	 */
	@Test
	public void testInsertatEnd() {
		LinkedList<String>list = new LinkedList<>();
		list.insert("Bonny");
		list.insert("Clyde");
		String correctString = "Bonny--> Clyde";
		assertEquals(correctString, list.toString());
		assertEquals("Bonny",list.getHead().getData());
	}

}

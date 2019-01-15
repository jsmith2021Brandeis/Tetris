/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 27, 2018
  *Assignment:Personal Study, tests the Linkedlist Node class
  *Bugs:
  */
package testHighScore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import HighScore.LinkedListNode;

public class testLinkedListNode {

	
	/**
	 * creates a new LinkedList node usingnext constructor and assesses its next and data fields
	 *also checks toString method
	 */
	@Test
	public void testDataConstructor() {
		LinkedListNode<String> node=new LinkedListNode<>("Jacob");
		assertEquals(null,node.getNext());
		assertEquals("Jacob",node.getData());
		String correctString="Jacob";
		assertEquals(correctString,node.toString());
	}
	
	/**
	 * creates a new LinkedList node using next and data constructor and assesses its next and data fields
	 *also checks to string method
	 */
	@Test
	public void testDataandNextConstructor() {
		LinkedListNode<String> node2=new LinkedListNode<>("Test");
		LinkedListNode<String> node1=new LinkedListNode<>("Jacob",node2);
		assertEquals(node2,node1.getNext());
		assertEquals("Jacob",node1.getData());
		String correctString="Jacob--> Test";
		assertEquals(correctString,node1.toString());
	}
	
	/**
	 * Creates a new LinkedListNode and tets get
	 */
	@Test
	public void testGetData() {
		LinkedListNode<String>node=new LinkedListNode<>("Jacob");
		assertEquals("Jacob",node.getData());
		
	}
	
	/**
	 * creates two new LinkedLists NOdes nad tests the get next method
	 */
	@Test
	public void testGetNext() {
		LinkedListNode<String>node1=new LinkedListNode<>("Jacob");
		LinkedListNode<String>node2=new LinkedListNode<>("Samuel",node1);
		assertEquals(node1,node2.getNext());
	}
	
	/**
	 * creates two new linkedListNodes and tests the setNext method
	 */
	@Test
	public void testSetNext() {
		LinkedListNode<String>node1=new LinkedListNode<>("Jacob");
		LinkedListNode<String>node2=new LinkedListNode<>("Samuel");
		assertEquals(null,node1.getNext());
		node1.setNext(node2);
		assertEquals(node2,node1.getNext());
	}
}

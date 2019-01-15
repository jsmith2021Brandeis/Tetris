/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 27, 2018
  *Assignment: Personal Study, Creates a Linked List to make a high score	
  *used  brackets from COSI 21a programming assignment 2
  *Bugs:
  *Notes: 5 minutes with a pen and notepad made inserting in reverse much more elegant!
  *does getHead violate encapsulation?
  */
package HighScore;

public class LinkedList<T extends Comparable<T>> {
	private LinkedListNode<T> head;

	public LinkedList() {
		head = null;
	}

	/**
	 * inserts the data at the end of the linked list
	 * 
	 * @param newData
	 *            the data to insert at the end
	 */
	public void insert(T newData) {
		LinkedListNode<T> toInsert = new LinkedListNode<>(newData);
		// check if inserting to first position
		if (head == null) {
			head = toInsert;
			return;
		}
		// otherwise, iterate along list until at last element
		LinkedListNode<T> cur = head;
		while (cur.getNext() != null) {
			cur = cur.getNext();
		}
		// insert new node at end of list
		cur.setNext(toInsert);

	}

	/**
	 * Inserts the data in a sorted part of linked list
	 * 
	 * @param newData
	 *            the data to insert into the list
	 */
	public void insertInReverseOrder(T newData) {
		
		//rule out all cases where list is 0 to 1 elements
		if (checkShortList(newData)) {
			return;
		}
		LinkedListNode<T> toInsert = new LinkedListNode<>(newData);
		// otherwise, travel down list
		LinkedListNode<T> cur = head;
		//advance as long as there is a next element and it is greater than the element to insert
		while (cur.getNext()!=null && cur.getNext().compareTo(toInsert)>0) {
			cur = cur.getNext();

		}
		//either the next element is less than the inserting element or we are at end of list
		//either way, insert here
		insert(toInsert, cur);
	}

	/**
	 * inserts newData in reverse order at the head
	 * @param newData the data to insert
	 * @return true if the list was that size, false otherwise
	 */
	private boolean checkShortList(T newData) {
		// if this is the first element in list, use normal insert method
		if (head == null) {
			this.insert(newData);
			return true;
		}
		// check if the new data is the highest of all, if so insert at front of list
		LinkedListNode<T> toInsert = new LinkedListNode<>(newData);
		if (toInsert.compareTo(head) > 0) {
			toInsert.setNext(head);
			head = toInsert;
			return true;
		
		} 
		return false;

	}

	/**
	 * Inserts node after data in the Linked list
	 * 
	 * @param data
	 *            the data to insert after
	 */
	public void insert(T newData, T dataInList) {
		LinkedListNode<T> cur = head;
		boolean match = cur.getData().equals(dataInList);
		while (cur != null && !match) {
			cur = cur.getNext();
			match = cur.getData().equals(dataInList);

		}
		if (cur == null) {
			throw new IllegalArgumentException("Data not found in linked List!");
		}
		LinkedListNode<T> toInsert = new LinkedListNode<T>(newData);
		insert(toInsert, cur);
	}
	
	/**
	 * return the head of the linked list
	 */
	public LinkedListNode<T> getHead() {
		return head;
	}

	/**
	 * Inserts the toInsert node into the linked list after the current node
	 * 
	 * @param toInsert
	 *            the node to insert into the linked list
	 * @param current
	 *            the place to insert in the linked list
	 */
	private void insert(LinkedListNode<T> toInsert, LinkedListNode<T> current) {
		LinkedListNode<T> temp = current.getNext();
		current.setNext(toInsert);
		toInsert.setNext(temp);

	}

	/**
	 * @return a String representation of linked list seperated by arrows
	 */
	public String toString() {
		return toString("--> ");
	}

	/**
	 * @return a String represnetation of the Linked List, like Jacob--> Samuel-->
	 *         Susan
	 * @param separator
	 *            how differnet data should be separated
	 */
	public String toString(String separator) {
		String s = "";
		LinkedListNode<T> cur = head;
		// If the current is null, return
		if (cur == null) {
			return s;
		}
		// otherwise, build a string representing the linked list
		s += cur.getData();
		while (cur.getNext() != null) {
			s += separator;
			cur = cur.getNext();
			s += cur.getData();

		}
		return s;

	}
}

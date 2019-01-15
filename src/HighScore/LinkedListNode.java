/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 27, 2018
  *Assignment:	Implements a simple Linked List for use in my high score class for Tetris Project
  *Bugs:
  *Notes: As an excersize, teh fields of the Linked List can't be changed. This will force me to ue the linkes of the list
  */
package HighScore;

public class LinkedListNode <T extends Comparable<T>> {
	private LinkedListNode<T> next;
	private T data;
	
	
	/**
	 * Creates new LinkedListNode only provided data
	 * @param data the data the LinkedList should hold
	 */
	public LinkedListNode(T data) {
		this(data,null);
	}
	
	/**
	 * Creates a new LinkedListNode provided next node and data
	 * @param next
	 * @param data
	 */
	public LinkedListNode(T data,LinkedListNode<T> next) {
		this.next=next;
		this.data=data;
	}
	
	/**
	 * returns the data held by the linkedListNode
	 * @return
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * FOr navigating along the Linked List
	 * @return the next LinkedListNode
	 */
	public LinkedListNode<T>getNext(){
		return next;
	}
	
	/**
	 * sets the next field
	 */
	public void setNext(LinkedListNode<T> next){
		this.next=next;
	}
		
	/**
	 * @return negative number if this nodes data is less than the parameter data
	 */
	public int compareTo(LinkedListNode<T>that) {
		T thisData=this.data;
		T thatData=that.getData();
		return thisData.compareTo(thatData);
	}
	
	/**
	 * return a string representation of the LinkedList Node
	 */
	public String toString() {
		String s= data.toString();
		if(next!=null) {
			T nextData=next.getData();
			s+="--> "+nextData.toString();
		}
		return s;
	}
}

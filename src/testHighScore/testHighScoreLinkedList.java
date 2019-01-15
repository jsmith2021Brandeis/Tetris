/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 27, 2018
  *Assignment:	Personal Study, tests how the linked list can be used to maintina a list of high scores
  *Bugs:
  */
package testHighScore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import HighScore.LinkedList;
import HighScore.Score;

public class testHighScoreLinkedList {
	
	LinkedList<Score>highScores;
	
	/**
	 * Inserts three names and high scores and checks state of linked list at each step
	 */
	@Test
	public void testInsertSequential() {
		highScores=new LinkedList<>();
		//every score will be 12 spaces long
		insertAndCheck("Jacob", 10,"Jacob    10 ");
		insertAndCheck("Susan", 30,"Susan    30 --> Jacob    10 ");
		insertAndCheck("Kathy", 20,"Susan    30 --> Kathy    20 --> Jacob    10 ");
			
	}
	
	/**
	 * Inserts three names and high scores in reverse order
	 * and checks state of linked list at each step
	 */
	@Test
	public void testInsertReverse() {
		highScores=new LinkedList<>();
		//every score will be 12 spaces long
		insertAndCheck("Jacob", 30,"Jacob    30 ");
		insertAndCheck("Susan", 20,"Jacob    30 --> Susan    20 ");
		insertAndCheck("Kathy", 10,"Jacob    30 --> Susan    20 --> Kathy    10 ");
			
	}
	
	/**
	 * Inserts a score into a linked list inOrder and asserts state of list
	 * @param name The name of the highscore
	 * @param score the score from the game
	 * @param correctString How the linked list should look after inserting
	 */
	public void insertAndCheck(String name, int score,String correctString) {
		Score s=new Score(name,score);
		highScores.insertInReverseOrder(s);
		assertEquals(correctString,highScores.toString());
	
	}
}

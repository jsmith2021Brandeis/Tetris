/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 27, 2018
  *Assignment:tests the score class of my tetris project	
  *Bugs:
  */
package testHighScore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import HighScore.Score;

public class testScore {

	/**
	 * tests the constructor and one line methods of Score class
	 */
	@Test
	public void testConstructor() {
		Score s = new Score("Jacob", 10);
		assertEquals("Jacob", s.getName());
		assertEquals(10, s.getScore());
		String correctString = "Jacob    10 ";
		assertEquals(correctString, s.toString());
	}

	/**
	 * tests the compareTo method of the score class
	 */
	@Test
	public void testCompareTo() {
		Score s1 = new Score("Jacob", 10);
		Score s2 = new Score("Samuel", 5);
		int correctCompare = 5;
		assertEquals(correctCompare, s1.compareTo(s2));
	}
	
	/**
	 * tests the encrypt and decrypt methods of the Score class
	 */
	@Test
	public void testDecoding() {
		//no wrapping letters
		encodeAndDecode("Jacob",10,1,  "Kbdpc    21 ");
		encodeAndDecode("Boob",55,-1,  "Anna     44 ");
		encodeAndDecode("Steve",600,10,"Cdofo    600");
		//wrapping letters like a to x
		encodeAndDecode("Dave",0,-3,   "Axsb     7  ");
		encodeAndDecode("Yanni",785,5, "Dfssn    230");
	}
	
	/**
	 * Helper method to encode and decode a Score
	 * @param name the name of who scores
	 * @param score the score they got
	 * @param shift how much to encode by
	 * @param correctEncoded the correctly encoded Score string
	 */
	private void encodeAndDecode(String name, int score,int shift,String correctEncoded) {
		//create score and save toString
		Score s1=new Score(name,score);
		String original=s1.toString();
		//encrypt Score and compare to known
		s1.Encrypt(shift);
		String encoded=s1.toString();
		assertEquals(correctEncoded,encoded);
		//decrypt score and see if it macthes original
		s1.Decrypt(shift);
		String decoded=s1.toString();
		assertEquals(original,decoded);
	}

}

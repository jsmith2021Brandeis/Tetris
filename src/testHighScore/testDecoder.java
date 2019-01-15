/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 28, 2018
  *Assignment:	Personal Study, tests the Decoder class of my Tetris Projects
  *Bugs:
  */
package testHighScore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import HighScore.Decoder;

public class testDecoder {
	
	/**
	 * Tests Decode class number methods with cipher helper method and correct examples
	 * on numbers
	 */
	@Test
	public void testEncoderNumbers() {
		cipher("100",1,"211");
		cipher("999",1,"000");
		cipher("000",1,"111");
		cipher("345",-9,"456");
		cipher("234",-4,"890");
	
	}
	
	/**
	 * Tests Decode class number methods with cipher helper method and correct examples
	 * on names
	 */
	@Test
	public void testEncoderNames() {
		cipher("Jacob",1,"Kbdpc");
		cipher("anna",1,"boob");
		cipher("Bcf",-1,"Abe");
		cipher("Sam",-3,"Pxj");
		cipher("Jeff",-5,"Ezaa");
	
	}
	
	/**
	 * Helper method to test Decode class, encodes and decodes a number making sure cipher
	 * is expected and the number can be decoded back to start
	 * @param num the message to encode
	 * @param shift the caesar shift to encode with
	 * @param correctCipher the correct cipher message
	 */
	public void cipher(String message, int shift, String correctCipher) {
		String cipher=Decoder.Encrypt(message, shift);
		assertEquals(correctCipher,cipher);
		String decoded=Decoder.Decrypt(cipher, shift);
		assertEquals(message,decoded);
	}
}

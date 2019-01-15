/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 28, 2018
  *Assignment:	Personaly Study, decrypts high scores for my Tetris program
  *  *Bugs: leading zeros make cipehring an integer complpicated
  *  However, I'm not really delaing with numbers, more like arrays, so String class is apropriate
  */
package HighScore;

public class Decoder {
	/**
	 * encrypts a message by a shift
	 * 
	 * @param message
	 *            the message to encrypt
	 * @param shift
	 *            the ceaser cipher shift
	 * @return the encrypted message
	 */
	public static String Encrypt(String message, int shift) {
		String cipher="";
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			// move char by shift on ascii table, wrappping back to 0
			cipher=cipher+shiftChar(c,shift);
		}
		return cipher;
	}

	/**
	 * shifts a character by a certain amount for ceasr cipher
	 * when its range is unknown
	 * @param c the character to encode
	 * @param shift how much to encode by
	 * @return the encoded character
	 */
	private static char shiftChar(char c, int shift) {
		
		if('0'<=c && c<='9') {
			return shiftChar('0','9',c,shift);
		}else if ('a'<=c && c<='z') {
			return shiftChar('a','z',c,shift);
		}else if ('A'<=c && c<='Z') {
			return shiftChar('A','Z',c,shift);
		}else {
			throw new IllegalArgumentException("Character must be alphanumeric!");
		}

	}
	/**
	 * Shifts a character by a certain amount for caesar cipher
	 * when its range is known
	 * @param low the lowest allowed character by ASCII
	 * @param high the highest allowed character by ASCII 
	 * @param c the original character
	 * @param shift how far the character will be shifted
	 * @return the encoded character
	 */
	private static char shiftChar(char low,char high, char c,int shift) {
			//reduce the shift to lowest factor
			int interval=high-low+1;
			shift=shift%interval;
			//shift the character
			c=(char)(c+shift);
			//handle wrapping
			if(c<low) {
				c+=interval;
			}else if (c>high) {
				c-=interval;
			}
			return c;
	}

	/**
	 * Decrypts the integer by encrypting it forward back to start if 4 was shift,
	 * then add 6 to get back to start, as there are 10 digits in cycle
	 * 
	 * @param message
	 *            the message to decrypt
	 * @param shift
	 *            the shift it was encrypted with
	 * @return the decrypted message
	 */

	public static String Decrypt(String message, int shift) {
		return Encrypt(message, -shift);
	}
}

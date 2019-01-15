/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 27, 2018
  *Assignment:Personal Study, holds the name and score for my high scores Teris project
  *Bugs: Score is stored as a string to preserve decoding information, but the encapsulation
  *	of this class means that the user doesn't need to know that
  */
package HighScore;

public class Score implements Comparable <Score>{
	private String name;
	private String score;
	
	/**
	 * creates a score record given a name and a score
	 * @param name who scored it
	 * @param score the score
	 */
	public Score(String name, int score) {
		this.name=name;
		this.score=Integer.toString(score);
	}
	
	/**
	 * 
	 * @return the score
	 */
	public int getScore() {
		return Integer.parseInt(score);
	}
	
	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Encrypt the score for safe storage
	 * @param shift how much to shift by in caesar cipher
	 */
	public void Encrypt(int shift) {
		name=Decoder.Encrypt(name, shift);
		score=Decoder.Encrypt(score, shift);
	}
	
	/**
	 * Decrypt the score for display
	 * @param shift how much to shift by in ceasr cipher
	 */
	public void Decrypt(int shift) {
		name=Decoder.Decrypt(name, shift);
		score=Decoder.Decrypt(score, shift);
		
	}
	
	/**
	 * @return a string representation of the score
	 */
	public String toString() {
		return String.format("%-8s %-3s", name,score);	
	}
	
	/**
	*returns negative number if this score is less than toCompare score
	*/
	public int compareTo(Score toCompare) {
		return getScore()-toCompare.getScore();
	}
}

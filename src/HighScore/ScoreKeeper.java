package HighScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Name: Jacob Smith Email:jsmith2021@brandeis.edu Date: Dec 27, 2018
 * Assignment: Personal Study, Maintains a list of the high scores of Tetris in
 * a local file Bugs: I have no idea why I need to use line sepearor here but
 * nowhere else? Source: file writing
 * https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
 * ALso don't write out to a file you are reading in to, also close reader then
 * output
 */

public class ScoreKeeper {

	private File f;
	private Scanner reader;
	private int shift;

	// parallel linked list holding names and scores
	private LinkedList<Score> scores;

	/**
	 * creates a new ScoreKeepr object
	 * 
	 * @param shift
	 *            the amount to shift by when encoding
	 */
	public ScoreKeeper(int shift) {
		f = new File("highscores.txt");
		try {
			reader = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scores = new LinkedList<>();
		this.shift = shift;
		loadHighScores();

	}

	/**
	 * reads the scores files, loading names and scores into a linked list of score
	 * objects
	 */
	private void loadHighScores() {
		// if the reader hasn't been intialized do nothing, such as if there is no
		// source
		// yet
		if (reader == null) {
			return;
		}
		while (reader.hasNext()) {
			String name = reader.next();
			int score = reader.nextInt();
			Score newScore = new Score(name, score);
			newScore.Decrypt(shift);
			scores.insert(newScore);
		}
	}

	/**
	 * Adds a new highscore to the file
	 * 
	 * @param name
	 *            the name of the scorer
	 * @param score
	 *            the highscore
	 */
	public void addHighScore(String name, int score) {
		Score toInsert = new Score(name, score);
		scores.insertInReverseOrder(toInsert);

	}

	/**
	 * Writes the scores to the file after encrypting them
	 *
	 */
	public void writeToFile() {
		// close the reader
		reader.close();
		// encrypt all the scores
		LinkedListNode<Score> cur = scores.getHead();
		while (cur != null) {
			Score s = cur.getData();
			s.Encrypt(shift);
			cur = cur.getNext();
		}
		// write them to the file
		PrintStream output;
		try {
			output = new PrintStream(f);
			output.print(this.getHighScores());
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return a string representing the high scores
	 */
	public String getHighScores() {
		return scores.toString(System.lineSeparator());
	}
	
	/**
	 * print decoded scores to console
	 */
	public static void printScore() {
		
		ScoreKeeper s = new ScoreKeeper(2);
		LinkedListNode<Score> cur = s.scores.getHead();
		String toDisplay = "";
		while (cur != null) {
			toDisplay += cur.getData().getScore() + "\n";
			cur = cur.getNext();

		}
		System.out.println(toDisplay);

	}
}

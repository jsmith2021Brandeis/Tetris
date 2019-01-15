/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 28, 2018
  *Assignment:	Personal Study, provides the methods to test my ScoreKeeper class
  *Bugs:
  */
package testHighScore;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import HighScore.ScoreKeeper;

public class testScoreKeeper {

	@Before
	/**
	 * Occurs before every test, wipes the scores clean
	 */
	public void clearFile() throws FileNotFoundException {

		File f = new File("highscores.txt");
		PrintStream output = new PrintStream(f);
		output.print("");
		output.close();
	}
	/**
	 * Adds 3 high scores to a blank record and checks the score readout and the
	 * record without encryption
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testScores() throws FileNotFoundException {
		// test scoring without encryption
		String correctString = "Tammy    30 " + System.lineSeparator() + "Jacob    20 " + System.lineSeparator()
				+ "Susan    10 ";
		testScoresHelper(0, correctString, correctString);
		clearFile();
		// test scoring with encryption
		String correctFileString = "Vcooa    52 " + System.lineSeparator() + "Lceqd    42 " + System.lineSeparator()
				+ "Uwucp    32 ";
		testScoresHelper(2, correctString, correctFileString);
		// test if ScoreKeeper can read the encrypted file, note no clearFile command
		ScoreKeeper fresh = new ScoreKeeper(2);
		correctString = "Tammy    30 " + System.lineSeparator() + "Jacob    20 " + System.lineSeparator()
		+ "Susan    10 ";
		assertEquals(correctString, fresh.getHighScores());
		
	}

	/**
	 * Tests if the ScoreKeeper can use the highscores file to save data between
	 * games
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testScoresSaving() throws FileNotFoundException {
		// run a previous test to get a file record
		String correctString = "Tammy    30 " + System.lineSeparator() + "Jacob    20 " + System.lineSeparator()
				+ "Susan    10 ";
		testScoresHelper(0, correctString, correctString);

		// create a new ScoreKeeper instance without encryption and see if it can read
		// the record
		ScoreKeeper s = new ScoreKeeper(0);
		// add high scores using the scoreKeepr, see if it got old results and also
		// inserted Tula correctly
		s.addHighScore("Tula", 60);
		correctString = "Tula     60 " + System.lineSeparator() + "Tammy    30 " + System.lineSeparator()
				+ "Jacob    20 " + System.lineSeparator() + "Susan    10 ";
		assertEquals(correctString, s.getHighScores());
		// write to the File
		s.writeToFile();
		// check the file
		String inFile = readFile();
		assertEquals(correctString, inFile);
	}

	/**
	 * Adds 3 high scores to a blank record and checks the score readout and the
	 * records
	 * 
	 * @throws FileNotFoundException
	 */
	private void testScoresHelper(int shift, String correctString, String correctFileString)
			throws FileNotFoundException {
		// create a new ScoreKeeper instance without encryption
		ScoreKeeper s = new ScoreKeeper(shift);
		// add high scores using the scoreKeepr
		// note how the scores are inserted any order, but printed in descending order
		s.addHighScore("Jacob", 20);
		s.addHighScore("Susan", 10);
		s.addHighScore("Tammy", 30);
		assertEquals(correctString, s.getHighScores());
		// write to the File
		s.writeToFile();
		// check the file
		String inFile = readFile();
		assertEquals(correctFileString, inFile);
	}

	/**
	 * helper method to examine the high scores text file
	 * 
	 * @return a String representation of the highscores file
	 * @throws FileNotFoundException
	 */
	private String readFile() throws FileNotFoundException {

		File f = new File("highscores.txt");
		Scanner reader = new Scanner(f);
		String s = "";
		if (reader.hasNextLine()) {
			s += reader.nextLine();
		}
		while (reader.hasNextLine()) {
			s += System.lineSeparator();
			s += reader.nextLine();
		}
		reader.close();
		return s;

	}

	
}

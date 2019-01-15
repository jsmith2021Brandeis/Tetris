package PlayGame;

import Navigation.Direction;
import Navigation.Mover;

/**
 * Name: Jacob Smith Email:jsmith2021@brandeis.edu Date: Dec 21, 2018
 * Assignment:Personal Study, a helper ethod Bugs:the game board is public
 * Making the board class lets me organize my code and also use toString as
 * printing
 * Source for newLine character
 * https://stackoverflow.com/questions/1090098/newline-in-jlabel
 * source for space:https://www.computerhope.com/jargon/n/nbsp.htm
 */

public class Board {
	protected boolean[][] board;
        private String newLine;
        private String space;
        boolean html;
        private int score;

        /**
         * Default constructor, creates a board object of
         * 20 rows 10 columns
         */
        public Board(){
            this(20,10);
        }
        
        
	/**
	 * Creates a new board object
         * @param length the number of rows of board object
         * @param width the number of columns of board object
	 */
	public Board(int length, int width) {
		this.board = new boolean[length][width];
        newLine="\n";
        space=" ";
        score=0;
	}
	
	/**
	 * 
	 * @return the current score of the board
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Moves a piece on the board
	 * 
	 * @param m
	 *            The piece to move
	 * @param dir
	 *            the direction the piece will move in
	 * @return whether the piece moved
	 */
	public boolean movePiece(Mover m, Direction dir) {
                
		boolean didMove = m.move(board, dir);
		//if the piece has stopped moving, check to clear the tetris board
		if(!didMove) {
			score+=Sweeper.clearTetris(board);
		}
		return didMove;
	}
	
	/**
	 * Places the piece on the board, returns false if it can't
	 * @param m the mover to place on the board
	 */
	public boolean placePiece(Mover m) {
		return m.place(board);
		
	}


	/**
	 * @return the length of the board
	 */
	public int getLength() {
		return board.length;
	}

	/**
	 * @return the width of the board Assumes the board isn't ragged
	 */
	public int getWidth() {
		return board[0].length;
	}

	/**
	 * helper method to print the border of the board
	 * 
	 * @return a string representing the border of the board
	 */
	private String printBorder() {
		String s = "";
		s += space;
		for (int i = 0; i < board.length; i++) {
			s += "_";
		}
		s += newLine;
		return s;
	}
	
	/**
	 * Helper method so toString can be called noramlly without score
	 *@return a string representation of the board 
	 */
	public String toString() {
		return toString(false);
	}

	/**
	 * prints the game board with borders
	 *@param needScore whether the score should be printed 
	 * @return a string representing the game board
	 */
	public String toString(boolean needScore) {
		
        String s = "";
		s += printBorder();
		for (int row = 0; row < board.length; row++) {
			s += "|";
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == true) {
					s += "[]";
				} else {
					s += space+space;
				}
			}
			s += "|";
                        s+=newLine;
		}
		s += printBorder();
        if(needScore) {
        	s+="Score="+score+"\n";
        }       
		return s;

	}
}

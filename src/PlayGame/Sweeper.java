/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 24, 2018
  *Assignment:	Personal Study, provides helper methods to clear completed rows and 
  *		cause pieces on top to fall down
  *		I split this clas off from Board class when Board calss was getting to long and I wanted to test clearingTetris
  *Bugs:
  *Sources:
  *https://www.youtube.com/watch?v=CvUK-YWYcaE 5 Minutes 35 seconds provides example of clearing board
  */
package PlayGame;

public class Sweeper {

	/**
	 * Clears any filled row, brings every piece down
	 * @param board the board to clear
	 * @return a score from number of tetris completed
	 */
	public static int clearTetris(boolean[][] board) {
		//go through the board
		int tetrisScore=0;
		int row = board.length - 1;
		while (row > 0) {
			boolean tetris = checkRow(board, row);
			// if a completion is achieved, clear it by bringing every piece one row down
			// and then checking from bottom again
			// wont be infinite loop because top row is set to be all false
			if (tetris) {
				clearRow(board, row);
				tetrisScore+=50;
				row = board.length - 1;
			} else {
				row--;
			}

		}
		return tetrisScore;

	}

	/**
	 * Checks if a row is completely filled
	 * 
	 * @param board
	 *            the 2d array to check
	 * @param row
	 *            the row to check
	 * @return whether the row is completely filled
	 */
	public static boolean checkRow(boolean[][] board, int row) {
		for (int col = 0; col < board[0].length; col++) {
			if (board[row][col] == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * moves every row above this one one down
	 * 
	 * @param rowToClear
	 *            the row to clear
	 */
	private static void clearRow(boolean[][] board, int rowToClear) {
		// if we get here, all bottom elements are true, so move board down
		// go down to not overwrite
		for (int row = rowToClear; row > 0; row--) {
			for (int col = 0; col < board[0].length; col++) {
				board[row][col] = board[row - 1][col];
			}
		}
		// erase top row
		for (int col = 0; col < board[0].length; col++) {
			board[0][col] = false;
		}

	}
}

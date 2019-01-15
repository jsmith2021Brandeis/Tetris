/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 20, 2018
  *Assignment:	Personal Study, this is an inheritacne scheme to allow me tosave code in the Mover class of my Tetris project
  *Bugs:
  */
package Navigation;

public abstract class Traverser {
	
	/**
	 * Will be overriden by subclasses to save code
	 * @param row the current row in board
	 * @param col the current column in board
	 * @param vertStart the vertical offset
	 * @param horizStart the horizontal offset
	 * @param pieceMap the smaller array that sets bounds
	 * @param board the larger array to traverse
	 * @param setValue what the state of the board should be set to, not alwyas used
	 * @return
	 */
	protected abstract boolean method(int row, int col, int vertStart, int horizStart,boolean[][]pieceMap, boolean[][]board, boolean setValue);
	
	/**
	 * Traverses every element in grid from given start and stop positions
	 * @param vertStart the row to start at
	 * @param horizStart the column to start at
	 * @param pieceMap the smaller array that confines size of array
	 * @param board the larger array to traverse
	 */
	public boolean boardTraverse(int vertStart, int horizStart, boolean[][] pieceMap,boolean[][]board,boolean setValue) {
	
		for (int row = vertStart; row < pieceMap.length + vertStart; row++) {
			for (int col = horizStart; col < pieceMap[0].length + horizStart; col++) {
				
				//if the method returns false, we cut out
				boolean result=method(row,col,vertStart,horizStart,pieceMap,board,setValue);
				if(result==false) {
					return false;
				}
			}
		}
		//if the method never returned false, we return true
		return true;
	}
	
	/**
	 * 
	 * @param row
	 *            the current row
	 * @param col
	 *            the current column
	 * @param pieceMap
	 *            the 2d array
	 * @return whether the row and column is within array bounds
	 */
	protected static boolean isInBounds(int row, int col, boolean[][] pieceMap) {
		boolean withinVertBounds = isBetween(row, 0, pieceMap.length-1);
		boolean withinHorizBounds = isBetween(col, 0, pieceMap[0].length-1);
		if (withinVertBounds && withinHorizBounds) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * helper method to check array bounds
	 * 
	 * @param num
	 *            the number to check
	 * @param min
	 *            the minimum bound
	 * @param max
	 *            the maximum bound
	 * @return whether num is between min and max
	 */
	protected static boolean isBetween(int num, int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Min must be less than or equal to max!");
		}
		if (num >= min && num <= max) {
			return true;
		} else {
			return false;
		}

	}
}
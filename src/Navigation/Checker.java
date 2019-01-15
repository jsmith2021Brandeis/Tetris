/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 20, 2018
  *Assignment: personal study, handles checking if a piece can move to a new location for my Tetris project	
  *Bugs:
  */
package Navigation;

public class Checker extends Traverser {
	
	
	/**
	 * Checks whether the piece can move to the new position
	 * because this method is called incrementally, it can only rule out overlap, never prove it
	 * @return whether the piece overlaps with the new position, if it does, return false
	 * @param setValue not used here
	 */
	@Override
	protected boolean method(int row, int col,int vertStart, int horizStart,boolean[][]pieceMap,boolean[][]board,boolean setValue) {
		boolean inBounds = isInBounds(row, col, board);
		// if the new sector is out of bounds and the piece as a part there
		if (!inBounds && pieceMap[row - vertStart][col - horizStart] == true) {
			return false;
		}
		//if the new sector is in bounds but the piece and the board overlap
		if (inBounds && board[row][col] == true && pieceMap[row - vertStart][col - horizStart] == true) {
			return false;
		}
		return true;
		
	}
}

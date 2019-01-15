/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 20, 2018
  *Assignment:	Personal study, handles placing a piece in new location in board, but doesn't update the old location
  *Bugs:
  */
package Navigation;

public class Placer extends Traverser {
	
	/**
	 * Modifies the board to actually move the piece
	 * @return always true
	 * by the time this method is called we already know that the piece and the board don't overlap,
	 * but we still check to mare sure and throw an exception
	 */
	@Override
	protected boolean method(int row, int col, int vertStart, int horizStart,boolean[][]pieceMap, boolean[][]board, boolean setValue) {
		
		boolean hasBit=pieceMap[row-vertStart][col-horizStart];
		boolean offBoard=!Traverser.isInBounds(row, col, board);
		
		if(offBoard && hasBit) {//this would be avoided if the checker is used properly
			throw new IllegalArgumentException("The piece is off off of the board!");
		}else if (!offBoard && hasBit) {//the only time the state of the board should be changed is when the piece at that location is true
			board[row][col]=setValue;
		}

		return true;
	}
}

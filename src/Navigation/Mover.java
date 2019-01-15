/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 19, 2018December 19 2018
  *Assignment:	Personal study, handles interaction between pieces and game board
   int my Tetris game
   I made this a seprate class to hide location from GamePiece object and to keep
   my classes short
   https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
   calculator class is source for lambda epxression
  *Bugs:
  *should placer and checker be static?
  *I handled erasing without giving myself a new state, resulted in more elegant solution through code reuse
  */
package Navigation;

import Pieces.GamePiece;
import Pieces.PieceName;

public class Mover extends GamePiece {
	// the row and column of upper left conrer of piece array
	int row;
	int col;

	private Checker checker;
	private Placer placer;

	/**
	 * Creates a new MOver object not given row and column starting the piece at -1
	 * to be just above the board
	 * 
	 * @param p
	 *            the name of the piece
	 */
	public Mover(PieceName p) {
		this(p, 0);
	}

	/**
	 * Creates a new mover object given row and column
	 * 
	 * @param p
	 *            the name of the piece
	 * @param row
	 *            the row to start out (-2 is default)
	 * @param col
	 *            the column to start at
	 */
	public Mover(PieceName p, int col) {
		super(p);
		this.row = -1;
		this.col = col;
		checker = new Checker();
		placer = new Placer();

	}

	/**
	 * 
	 * @return the current row of the mover
	 */
	public int getRow() {
		return row;
	}

	/**
	 * 
	 * @return the current column of the mover
	 */
	public int getCol() {
		return col;
	}

	/**
	 * helper method to place piece on board
	 * 
	 * @param board
	 *            the board to place the piece on
	 * @return whether the piece can be placed
	 */
	public boolean place(boolean[][] board) {
		// placing is just moving piece down from row -1 to row 0 if possible
		return this.move(board, Direction.DOWN);

	}

	/**
	 * given a board, move down a space if it can
	 * 
	 * @param board
	 *            the current game board
	 * @dir the direction the piece should move in
	 * @return whether the piece can move down a space
	 */
	public boolean move(boolean[][] board, Direction dir) {

		boolean[][] pieceMap = getPieceMap();

		if (row >= 0) {
			// erase the old position of the piece, only occurs if piece was on board
			placer.boardTraverse(this.row, this.col, pieceMap, board, false);
		}
		// check if the piece can move to new location
		int horizStart = dir.getHorizOffset() + this.col;
		int vertStart = dir.getVertOffset() + this.row;
		boolean rotatedLeft = false;
		// rotate the piece if that was the direction called for and update the pieceMap
		if (dir.equals(Direction.ROTATELEFT)) {
			this.rotateLeft();
			rotatedLeft = true;
			pieceMap=this.getPieceMap();
		}

		boolean canMove = checker.boardTraverse(vertStart, horizStart, pieceMap, board, false);

		// if the piece can move, update its location
		if (canMove) {
			this.row += dir.getVertOffset();
			this.col += dir.getHorizOffset();
		} else if (rotatedLeft) {// if the piece can't move, and it was rotated, rotate it back
			this.rotateRight();
			//also pieceMap must be updated
			pieceMap=this.getPieceMap();
		}
		// write the piece back onto the board if it is on the board
		if (row >= 0) {
			placer.boardTraverse(this.row, this.col, pieceMap, board, true);
		}
		return canMove;

	}

}

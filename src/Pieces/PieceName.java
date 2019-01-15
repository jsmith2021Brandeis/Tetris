package Pieces;
/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 19, 2018December 19 2018
  *Assignment:	Personal Study, this is the library of possible tetris pieces for my tetirs project
  *Bugs:
  *Sources:
  *https://dzone.com/articles/using-java-enums
  *https://www.vectorstock.com/royalty-free-vector/tetris-bricks-pieces-total-set-for-game-vector-7541583
  * I'm also using the toString method from the provided HumanSimResponses class of my cosi 12B
  * Wow, enums make things so much more elegant!
  */

public enum PieceName {
	
	TRIBLOCK("01001110"),
	/*  
	 *   []
	 * [][][]
	 * 
	 * 
	 * */
	LONGPIECE("11110000"),
	/*
	 *[][][][] 
	 *
	 *
	 *
	 * */
	SQUARE("11001100"),
	/*
	 * [][]
	 * [][]
	 * 
	 * 
	 */
	LPIECE("10001110"),
	/*
	 * []
	 * [][][]
	 * 
	 * 
	 * */
	LPIECEBACKWARD("00101110"),
	/*
	 *     []
	 * [][][]
	 * 
	 * 
	 * */
	SNAKEPIECE("11000110"),
	/*
	 * [][]
	 *   [][]
	 *   
	 *   
	 */
	SNAKEPIECEBACKWARD("01101100");
	/*
	 *  [][]
	 *[][]
	 *
	 * 
	 */

	
	private final String pieceMap;
	
	/**
	 * creates a new PieceName
	 * @param pieceMap the code representing that piece
	 */
	private PieceName(String pieceMap) {
		this.pieceMap=pieceMap;
	}
	
	/**
	 * returns the code of that name
	 */
	public String toString() {
		return pieceMap;
	}
}

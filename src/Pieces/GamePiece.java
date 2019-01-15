package Pieces;

/**
 * Name: Jacob Smith Email:jsmith2021@brandeis.edu Date: Dec 19, 2018December 19
 * 2018 Assignment: Personal Study, represents a gamepiece in tetris Bugs:
 * 
 * make enum for piece strings forreadiabilty and improvement
 * I am trading off memory for privacy in getPieceMap method
 * Also, I am expressing the piece as trues in a larger box, but I could restate it as jagged array of only its contents...
 * going right needs to start with one plus, it starts at col 0
 */

public class GamePiece {

	private boolean[][] pieceMap;
	
	/**
	 * Create a new GamePiece object
	 * @param binaryPiece the string representing the shape of the object
	 */
	public GamePiece(PieceName p)  {
		pieceMap=populatePieceMap(p.toString());
		
	}
	
	/**
	 * helper method to convert a string of os and 1s into a 2d array representing the piece
	 * @param binaryPiece the String to convert to array
	 * @return an array representing the piece
	 */
	private static boolean[][] populatePieceMap(String binaryPiece) {
		//use the string of zeros and 1s to populate array
		//the piece map needs to be 4 X 4 to allow rotations
				boolean [][]tempMap=new boolean[4][4];
				for(int row=0;row<tempMap.length-2;row++) {
					for(int col=0;col<tempMap[0].length;col++) {
						//the calculation goes from the row and column in the array to the index of tge string to look for
						char c=binaryPiece.charAt((row)*4+col);
						if (c=='0') {
							tempMap[row][col]=false;
						}else {// c=='1'
							tempMap[row][col]=true;
						}
						
					}
					
				}
				return tempMap;
						
	}
	
	
	/**
	 *rotates the piece matrix right using Patel's code
	 */
	public void rotateRight() {
		pieceMap=RotateMatrix.rotateRight(pieceMap);
	}
	
	/**
	 *rotates the piece matrix left using Patel's code
	 */
	public void rotateLeft() {
		pieceMap=RotateMatrix.rotateLeft(pieceMap);
	}
	
	
	/**
	 * Getter method to maintain the integrity of the pieceMap
	 * @return a copy of the piece map
	 */
	public boolean[][]getPieceMap(){
		boolean[][]tempMap=new boolean[pieceMap.length][pieceMap[0].length];
		for (int row=0;row<pieceMap.length;row++) {
			for(int col=0;col<pieceMap[0].length;col++) {
				tempMap[row][col]=pieceMap[row][col];
			}
		}
		return tempMap;
	}
	

	/**
	 * returns a string representaiton of the piece by going through pieceMap
	 * so 01001111 would be 
	 *    []
	 *  [][][]
	 */
	public String toString() {
		String s="";
		//iterate along rows
		for (int row=0;row<pieceMap.length;row++) {
			//iterate along columns
			for (int col=0;col<pieceMap[0].length;col++) {
				//check string representation, populate array accordingly
				if(pieceMap[row][col]==true) {
					s+="[]";
				}else {
					s+="  ";
				}
			}
			s+="\n";
		}
		return s;
		
	}

}


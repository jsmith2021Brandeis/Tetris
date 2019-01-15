/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 21, 2018
  *Assignment:	Personal Study, hlper methods to generate testing grids
  *Bugs:
  */
package testNavigation;

import Pieces.GamePiece;
import Pieces.PieceName;

public class genGrids {
	
	
	/**
	 * helper method to create a pieceMap to test with
	 * @return the grid
	 */
	public static boolean[][]createPieceMap(){
		GamePiece p=new GamePiece(PieceName.TRIBLOCK);
		return p.getPieceMap();
	}
	
	
	/**
	 * helper method to create a grid to test with
	 * @return the grid
	 */
	public static boolean[][]createBlankBoard(){
		/* "        "
		 * "        "
		 * "        "
		 * "        "
		 * false false false false
		 */
		boolean[][]grid=new boolean[4][4];
		return grid;
	}
	
	
	/**
	 * helper method to create a partially filled vetical grid to test with
	 * @return the grid
	 */
	public static boolean[][]createPartiallyFilledBoardVert(){
		/*
		 * "        "
		 * "        "
		 * "[][][][]"
		 * "[][][][]"
		 */
		boolean[][]grid=new boolean[4][4];
		
		for(int row=grid.length/2;row<grid.length;row++) {
			for(int col=0;col<grid[0].length;col++) {
				grid[row][col]=true;
			}
		}
		return grid;
	}
	
	/**
	 * helper method to create a partially filled horizontal grid to test with
	 * @return the grid
	 */
	public static boolean[][]createPartiallyFilledBoardHoriz(){
		/*
		 * 
		 * "    [][]"
		 * "    [][]"
		 * "    [][]"
		 * "    [][]"
		 */
		boolean[][]grid=new boolean[4][4];
		
		for(int row=0;row<grid.length;row++) {
			for(int col=2;col<grid[0].length;col++) {
				grid[row][col]=true;
			}
		}
		return grid;
	}
	
	
	/**
	 * helper method to create a partially filled grid in inverse of rotated tri block
	 * this checks if the Checker allows overlap, ie if the htbox of the piece is penetrable, which it should be
	 * @return the grid
	 */
	public static boolean[][]createInverse(){
		/*
		 * "        "
		 * "        "
		 * "  []    "
		 * "[][][]  "
		 */
		boolean[][]grid=new boolean[4][4];
		
		grid[2][1]=true;
		grid[3][0]=true;
		grid[3][1]=true;
		grid[3][2]=true;
		return grid;
	}
	
	/**
	 * helper method to create a completely filled grid
	 * for testing the Erasing functiono of the Placer class
	 * @return the grid
	 */
	public static boolean[][]createFull(){
		/*
		 * "[][][][]"
		 * "[][][][]"
		 * "[][][][]"
		 * "[][][][]"
		 */
		boolean[][]grid=new boolean[4][4];
		for (int row=0;row<grid.length;row++) {
			for(int col=0;col<grid[0].length;col++) {
				grid[row][col]=true;
			}
		}
		return grid;
	}
	
	/**
	 * helper method for array comparisons
	 * 
	 * @param A
	 *            a 2d array
	 * @return a string representation of the array
	 */
	public static String ArrtoString(boolean[][] A) {
		String s = "";
		for (int row = 0; row < A.length; row++) {
			for (int col = 0; col < A[0].length; col++) {
				if (A[row][col] == true) {
					s += "[]";
				} else {
					s += "  ";
				}

			}
			s += "\n";
		}
		return s;

	}

}

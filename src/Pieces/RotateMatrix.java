package Pieces;
/**
 * Using Java by Patel Code
 * http://javabypatel.blogspot.com/2016/11/rotate-matrix-by-90-degree-java.html
 * Assignment: personal study, making a tetris game
 */

public class RotateMatrix {


	// Rotate Matrix to 90 degree toward Right(clockwise)
	public static boolean[][] rotateRight(boolean[][] matrix) {

		int totalRowsOfRotatedMatrix = matrix[0].length; // Total columns of Original Matrix
		int totalColsOfRotatedMatrix = matrix.length; // Total rows of Original Matrix

		boolean[][] rotatedMatrix = new boolean[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				rotatedMatrix[j][(totalColsOfRotatedMatrix - 1) - i] = matrix[i][j];
			}
		}
		return rotatedMatrix;
	}

	// Rotate Matrix to 90 degree toward Left(counter clockwise)
	public static boolean[][] rotateLeft(boolean[][] matrix) {

		int totalRowsOfRotatedMatrix = matrix[0].length; // Total columns of Original Matrix
		int totalColsOfRotatedMatrix = matrix.length; // Total rows of Original Matrix

		boolean[][] rotatedMatrix = new boolean[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				rotatedMatrix[(totalRowsOfRotatedMatrix - 1) - j][i] = matrix[i][j];
			}
		}
		return rotatedMatrix;
	}
}

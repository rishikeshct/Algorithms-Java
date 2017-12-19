package com.geeksforgeeksalgos.solutions;

public class MatrixPrinting {

	public static void main(String[] args) {

		String str = "TOP";
		int length = str.length();
		MatrixPattern(str, length);

	}

	private static void MatrixPattern(String str, int length) {
		char[][] strMatrix = new char[length][length];

		// add X in all matrix positions
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				strMatrix[i][j] = 'X';
			}
		}

		// insert vertically the given string
		for (int i = 0; i < length; i++) {
			strMatrix[i][length / 2] = str.charAt(i);
		}

		// insert Horizontally the given element
		for (int i = 0; i < length; i++) {
			strMatrix[length / 2][i] = str.charAt(i);
		}

		// To print array
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(strMatrix[i][j] + "  ");
			}
			System.out.println();
		}
	}

}

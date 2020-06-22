package com.leetcode.matrices;

import java.util.HashSet;
import java.util.Set;

/*
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {

			boolean isValidRow = isValidRow(board, i);

			boolean isValidCol = isValidColumn(board, i);

			if (!isValidRow || !isValidCol)
				return false;
		}

		return isValidBox(board);
	}

	private boolean isValidRow(char[][] grid, int rowNum) {

		char row[] = grid[rowNum];
		Set<Character> nums = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			char c = row[i];

			if (c == '.' || nums.add(c)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isValidColumn(char[][] grid, int colNum) {

		Set<Character> nums = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			char c = grid[i][colNum];

			if (c == '.' || nums.add(c)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isValidBox(char[][] grid) {
		Set<Character> nums = new HashSet<>();
		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				nums.clear();
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						char c = grid[k][l];

						if (c == '.' || nums.add(c)) {
							continue;
						} else {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
//		char board[][] = {{'8','3','.','.','7','.','.','.','.'},
//		                 {'6','.','.','1','9','5','.','.','.'},
//		                 {'.','9','8','.','.','.','.','6','.'},
//		                 {'8','.','.','.','6','.','.','.','3'},
//		                 {'4','.','.','8','.','3','.','.','1'},
//		                 {'7','.','.','.','2','.','.','.','6'},
//		                 {'.','6','.','.','.','.','2','8','.'},
//		                 {'.','.','.','4','1','9','.','.','5'},
//		                 {'.','.','.','.','8','.','.','7','9'}};
		
		char board[][] = {{'.','.','4','.','.','.','6','3','.'},
		                  {'.','.','.','.','.','.','.','.','.'},
		                  {'5','.','.','.','.','.','.','9','.'},
		                  {'.','.','.','5','6','.','.','.','.'},
		                  {'4','.','3','.','.','.','.','.','1'},
		                  {'.','.','.','7','.','.','.','.','.'},
		                  {'.','.','.','5','.','.','.','.','.'},
		                  {'.','.','.','.','.','.','.','.','.'},
		                  {'.','.','.','.','.','.','.','.','.'}};
		
		ValidSudoku vs = new ValidSudoku();
		System.out.println("Suduko is " + (vs.isValidSudoku(board) ? "valid" : "invalid"));
	}
}

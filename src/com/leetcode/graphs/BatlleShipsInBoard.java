package com.leetcode.graphs;

/*
 * 419. Battleships in a Board
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class BatlleShipsInBoard {
	
	/*
	 * Time: O(M*N) and Space: O(M*N)
	 */
	public int countBattleships(char[][] board) {

		int battleShips = 0;

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == 'X') {
					battleShips++;
					dfs(board, row, col);
				}
			}
		}

		return battleShips;
	}
	
	
	private void dfs(char[][] board, int row, int col) {
		
		if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] == '.') {
			return;
		}
		
		board[row][col] ='.';
		
		dfs(board, row, col + 1);
		dfs(board, row, col - 1);
		dfs(board, row + 1, col);
		dfs(board, row - 1, col);
	}
	
	
	/*
	 * Time: O(M*N) and Space: O(1)
	 */
	public int countBattleships2(char[][] board) {

		int battleShips = 0;

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == '.') {
					continue;
				}

				if (i > 0 && board[i - 1][j] == 'X') {
					continue;
				}

				if (j > 0 && board[i][j - 1] == 'X') {
					continue;
				}

				battleShips++;
			}
		}

		return battleShips;
	}
}

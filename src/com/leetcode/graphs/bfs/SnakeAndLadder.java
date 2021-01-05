package com.leetcode.graphs.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadder {

	public int snakesAndLadders(int[][] board) {
		int N = board.length;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		Map<Integer, Integer> dist = new HashMap<>();
		dist.put(1, 0);

		while (!queue.isEmpty()) {
			int src = queue.remove();

			if (src == N * N)
				return dist.get(src);

			// should not go beyond N*N
			for (int dest = src + 1; dest <= Math.min(src + 6, N * N); dest++) {

				int rc = getRC(dest, N);
				int r = rc / N;
				int c = rc % N;

				int finalPos = board[r][c] == -1 ? dest : board[r][c];

				if (!dist.containsKey(finalPos)) {
					dist.put(finalPos, dist.get(src) + 1);
					queue.add(finalPos);
				}
			}
		}
		return -1;
	}

	/*
	 * returnVal = row * N + col; return row * N + col => returnVal / N wil give row
	 * and returnVal % N will give column
	 * 
	 * matrix starts from (0,0) but the board game starts from (N - 1, 0)
	 * 
	 * for position 5 => (r, c) should be (5, 4)
	 */
	public int getRC(int pos, int N) {

		int quot = (pos - 1) / N;
		int rem = (pos - 1) % N;
		int row = (N - 1) - quot;
		int col = (row % 2 != N % 2) ? rem : ((N - 1) - rem);

		return row * N + col;
	}

	public static void main(String[] args) {

		SnakeAndLadder sal = new SnakeAndLadder();

	}
}

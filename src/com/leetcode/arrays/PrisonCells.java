package com.leetcode.arrays;

import java.util.Arrays;

import com.leetcode.utils.ArrayUtils;

public class PrisonCells {

	/*
	 * If first operation if it repeats after x cycles then it would keep repeating,
	 * so N = N % cycle;
	 */
	public int[] prisonAfterNDays(int[] cells, int N) {

		int cycle = 1;
		int first[] = new int[8];

		for (int i = 1; i < 7; i++) {
			first[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
		}
		N -= 1;

		for (int i = 0; i < 8; i++)
			cells[i] = first[i];

		while (N-- > 0) {

			int temp[] = new int[8];

			for (int i = 1; i < 7; i++) {
				temp[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
			}

			if (Arrays.equals(temp, first))
				N %= cycle;

			for (int i = 0; i < 8; i++)
				cells[i] = temp[i];

			cycle++;
		}

		return cells;

	}

	/*
	 * Time limit exceeded
	 */
	public int[] prisonAfterNDays2(int[] cells, int N) {

		for (int i = 1; i < N; i++) {
			cells[0] = 0;

			int curr = cells[0];
			int prev = cells[0];

			for (int j = 1; j < 7; j++) {
				curr = cells[j];
				if ((prev == 0 && cells[j + 1] == 0) || (prev == 1 && cells[j + 1] == 1)) {
					cells[j] = 1;
				} else {
					cells[j] = 0;
				}
				prev = curr;
			}
			cells[7] = 0;
			ArrayUtils.print(cells);
		}

		return cells;
	}

	public static void main(String[] args) {

		int cells[] = { 0, 1, 0, 1, 1, 0, 0, 1 };
		int N = 7;
		PrisonCells pcells = new PrisonCells();
		pcells.prisonAfterNDays(cells, N);

	}
}

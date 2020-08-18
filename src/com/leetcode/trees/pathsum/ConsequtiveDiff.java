package com.leetcode.trees.pathsum;

import java.util.ArrayList;
import java.util.List;

public class ConsequtiveDiff {

	public int[] numsSameConsecDiff(int N, int K) {

		if (N == 1) {
			return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		}
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i < 10; i++) {
			dfs(i, N - 1, K, result);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	private void dfs(int num, int N, int K, List<Integer> result) {

		if (N == 0) {
			result.add(num);
			return;
		}

		List<Integer> nextDigits = new ArrayList<>();
		int unitPlaceDigit = num % 10;

		nextDigits.add(unitPlaceDigit + K);
		if (K != 0) {
			nextDigits.add(unitPlaceDigit - K);
		}

		for (int nextDigit : nextDigits) {
			if (nextDigit >= 0 && nextDigit < 10) {
				int newNum = num * 10 + nextDigit;
				dfs(newNum, N - 1, K, result);
			}
		}
	}
}

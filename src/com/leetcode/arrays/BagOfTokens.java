package com.leetcode.arrays;

import java.util.Arrays;

/*
 * 948. Bag of Tokens
 * https://leetcode.com/problems/bag-of-tokens/
 */
public class BagOfTokens {

	public int bagOfTokensScore(int[] tokens, int P) {
		Arrays.sort(tokens);
		int low = 0;
		int high = tokens.length - 1;
		int token = 0;
		int maxTokens = 0;

		while (low <= high) {
			if (P >= tokens[low]) {
				P -= tokens[low];
				low++;
				token++;
				maxTokens = Math.max(token, maxTokens);
			} else if (token > 0) {
				P += tokens[high];
				high--;
				token--;
			} else {
				return maxTokens;
			}
		}
		return maxTokens;
	}
}

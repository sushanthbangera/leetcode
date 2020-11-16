package com.leetcode.strings.substring;

/*
 * 686. Repeated String Match
 * https://leetcode.com/problems/repeated-string-match/
 */
public class RepeatedStringMatch {

	/*
	 * Time: O(n), n length of string b
	 */
	public int repeatedStringMatch(String a, String b) {

		int q = 1;

		StringBuilder str = new StringBuilder(a);

		while (str.length() < b.length()) {
			str.append(a);
			q++;
		}

		if (str.indexOf(b) > -1)
			return q;

		if (str.append(a).indexOf(b) > -1)
			return q + 1;

		return -1;
	}
}

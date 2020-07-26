package com.leetcode.strings;

/*
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class MyAtoi {

	/*
	 * Time: O(N) - N is length of the String Space: O(1)
	 */
	public int myAtoi(String str) {

		if (str.length() == 0)
			return 0;

		int i = 0;
		int total = 0, sign = 1;

		// remove white spaces
		while (i < str.length() && str.charAt(i) == ' ')
			i++;

		if (str.length() == i)
			return 0;

		// handle the signs
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			sign = (str.charAt(i) == '-') ? -1 : 1;
			i++;
		}

		while (i < str.length()) {
			int digit = str.charAt(i) - '0';
			if (digit < 0 || digit > 9)
				break;

			// handle overflow
			if (total > Integer.MAX_VALUE / 10 || total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			total = total * 10 + digit;
			i++;
		}

		return total * sign;
	}

	public static void main(String[] args) {
		MyAtoi atoi = new MyAtoi();
		String str = "-912346735234";

		System.out.println(Integer.MAX_VALUE / 10);
		System.out.println(Integer.MAX_VALUE % 10);
		System.out.println(atoi.myAtoi(str));
	}
}

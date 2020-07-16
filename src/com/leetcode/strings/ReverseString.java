package com.leetcode.strings;

/*
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

	/*
	 * Using 2 pointers
	 * Time: O(N) to perform N/2 swaps
	 * Space: O(1)
	 */
	public void reverseString(char[] s) {

		int len = s.length;

		int low = 0, high = len - 1;

		while (low < high) {
			char temp = s[low];
			s[low] = s[high];
			s[high] = temp;
			low++;
			high--;
		}
	}

	/*
	 * Using 1 pointer
	 */
	public void reverseString2(char[] s) {

		int len = s.length;

		for (int i = 0; i < s.length / 2; i++) {
			char temp = s[len - 1 - i];
			s[len - 1 - i] = s[i];
			s[i] = temp;
		}
	}

	/*
	 *  Time: O(N) to perform N/2 swaps
	 *  Space: O(N) to keep the recursion stack
	 */
	public void reverseString3(char[] s) {
		reverseUtil(s, 0, s.length - 1);
	}

	private void reverseUtil(char[] s, int start, int end) {

		if (start >= end)
			return;

		char temp = s[start];
		s[start++] = s[end];
		s[end--] = temp;
		reverseUtil(s, start, end);
	}

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();

		String s = "I am in love with leetcode";
		char[] str = s.toCharArray();
		rs.reverseString2(str);
		System.out.println(new String(str));

		String t = "How do I program in Java";
		char[] st = t.toCharArray();
		rs.reverseString2((st));
		System.out.println(new String(st));
		
		String u = "Where do we find it?";
		char[] su = u.toCharArray();
		rs.reverseString3((su));
		System.out.println(new String(su));
	}
}

package com.leetcode.strings;

/*
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

	/*
	 * Time: O(N) Space: O(1)
	 */
	public boolean isPalindrome(String s) {

		int start = 0;
		int end = s.length() - 1;
		s = s.toLowerCase();
		
		char sChar, eChar;
		
		while (start < end) {
			sChar = s.charAt(start);
			eChar = s.charAt(end);
			
			if (!Character.isLetterOrDigit(sChar)) {
				start++;
			} else if(!Character.isLetterOrDigit(eChar)) {
				end--;
			} else {
				if (sChar != eChar) {
					return false;
				}
				start++;
				end--;
			}
		}
		return true;
	}
}

package com.leetcode.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {

	/*
	 * Time: O(n) Space: O(n) for character array
	 */
	public String reverseVowels(String s) {

		if (s == null || s.length() == 0) {
			return s;
		}

		Set<Character> vowels = new HashSet<>();
		setVowels(vowels);

		int len = s.length();

		char[] result = s.toCharArray();

		int i = 0;
		int j = len - 1;

		while (i < j) {

			while (i < j && !vowels.contains(result[i])) {
				i++;
			}

			while (i < j && !vowels.contains(result[j])) {
				j--;
			}

			char temp = result[i];
			result[i] = result[j];
			result[j] = temp;
			i++;
			j--;
		}

		return new String(result);
	}

	/*
	 * Time: O(n) Space: O(n + m) // m is the number of vowels - stored in stack
	 */
	public String reverseVowels2(String s) {

		if (s == null || s.length() == 0) {
			return s;
		}

		Set<Character> vowels = new HashSet<>();
		setVowels(vowels);

		int len = s.length();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			if (vowels.contains(s.charAt(i))) {
				stack.push(s.charAt(i));
			}
		}
		char[] result = new char[len];
		for (int i = 0; i < len; i++) {
			if (vowels.contains(s.charAt(i))) {
				result[i] = stack.pop();
			} else {
				result[i] = s.charAt(i);
			}
		}

		return new String(result);
	}

	private void setVowels(Set<Character> vowels) {
		vowels.add('a');
		vowels.add('A');
		vowels.add('e');
		vowels.add('E');
		vowels.add('i');
		vowels.add('I');
		vowels.add('o');
		vowels.add('O');
		vowels.add('u');
		vowels.add('U');
	}
}

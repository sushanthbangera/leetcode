package com.leetcode.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 824. Goat Latin
 * https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin {

	private Set<Character> vowels = new HashSet<>(
			Arrays.asList(new Character[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' }));

	/*
	 * Time: O(N^2) Space: O(N^2) where N is the length of the string
	 */
	public String toGoatLatin(String S) {

		StringBuilder result = new StringBuilder();
		String suffix = "a";

		for (String word : S.split("\\s+")) {

			if (!vowels.contains(word.charAt(0))) {
				word = word.substring(1) + word.charAt(0);
			}
			result.append(word).append("ma").append(suffix).append(" ");
			suffix += "a";
		}

		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}

	public static void main(String[] args) {
		String str = "I speak Goat Latin";
		GoatLatin gl = new GoatLatin();
		System.out.println(gl.toGoatLatin(str));
	}
}

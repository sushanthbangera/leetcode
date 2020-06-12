package com.leetcode.strings;

/*
 * 953. Verifying an Alien Dictionary
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class AlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {

		int len = order.length();
		int[] charArray = new int[26];
		for (int i = 0; i < len; i++) {
			charArray[order.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				
				//Iteration should be till the minimum length among the 2 words
				int min = Math.min(words[i].length(), words[j].length());
				
				for (int k = 0; k < min; k++) {
					int char1 = charArray[words[i].charAt(k) - 'a'];
					int char2 = charArray[words[j].charAt(k) - 'a'];

					if (char1 < char2) {
						break;
					} else if (char1 > char2) {
						return false;
					} else if (k == min - 1 && words[i].length() > words[j].length()) { // handling 3rd test case
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		AlienDictionary alienDictionary = new AlienDictionary();

		String[] words = { "hello", "leetcode" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";

		System.out.println(
				"The dictonaty is " + (alienDictionary.isAlienSorted(words, order) ? "sorted" : "not sorted"));

		String[] words2 = { "word", "world", "row" };
		String order2 = "worldabcefghijkmnpqstuvxyz";

		System.out.println(
				"The dictonaty is " + (alienDictionary.isAlienSorted(words2, order2) ? "sorted" : "not sorted"));

		String[] words3 = { "apple", "app" };
		String order3 = "abcdefghijklmnopqrstuvwxyz";

		System.out.println(
				"The dictonaty is " + (alienDictionary.isAlienSorted(words3, order3) ? "sorted" : "not sorted"));
	}
}

package com.leetcode.strings;

/*
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseStringWords {

	public String reverseWords(String s) {

		s = s.trim();
		String[] str = s.split("\\s+");

		int len = str.length;

		int low = 0;
		int high = len - 1;

		while (low < high) {
			String temp = str[low];
			str[low] = str[high];
			str[high] = temp;
			low++;
			high--;
		}
		return String.join(" ", str);
	}
	
	public String reverseWords2(String s) {

		s = s.trim();
		
		String[] str = s.split("\\s+");
		int len = str.length;
		
		String reverseArray[] = new String[len];
		
		for (int i = len - 1, j = 0; i >=0; i--, j++) {
			reverseArray[j] = str[i];
		}
		
		return String.join(" ", reverseArray);
	}
	
	public String reverseWords3(String s) {
		if (s == null || s.length() == 0)
			return s;

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ' ')
				continue;

			int start = i;

			while (i < s.length() && s.charAt(i) != ' ') {
				i++;
			}

			if (result.length() == 0) {
				result.insert(0, s.substring(start, i));
			} else {
				result.insert(0, " ").insert(0, s.substring(start, i));
			}
		}
		return result.toString();

	}
	
	public static void main(String[] args) {
		ReverseStringWords rsw = new ReverseStringWords();
		String s = "I love Programming in Java";
		System.out.println(s);
		
		System.out.println(rsw.reverseWords(s));
		
		System.out.println(rsw.reverseWords2(s));
		
		System.out.println(rsw.reverseWords3(s));
	}
}

package com.leetcode.math;

/*
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelColumnNumber {

	/*
	 * Time: O(N) Space: O(1)
	 */
	public int titleToNumber(String s) {

		int column = 0;

		for (int i = 0; i < s.length(); i++) {
			column *= 26;
			column += s.charAt(i) - 'A' + 1;
		}

		return column;
	}
}

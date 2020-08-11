package com.leetcode.math;

/*
 * 168. Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelColumnName {

	public String convertToTitle(int n) {

		StringBuilder columnName = new StringBuilder();

		while (n > 0) {
			int rem = n % 26;

			if (rem == 0) {
				columnName.append("Z");
				n = n / 26 - 1;
			} else {
				char c = (char) (rem - 1 + 'A');
				columnName.append(c);
				n = n / 26;
			}
		}

		return columnName.reverse().toString();
	}
	
	public static void main(String[] args) {
		ExcelColumnName ecn = new ExcelColumnName();
		int n = 702;
		System.out.println(ecn.convertToTitle(n));
	}
}

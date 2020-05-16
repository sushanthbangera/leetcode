package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/*
 *  13. Roman to Integer
 *  https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

	public int romanToInt(String s) {
		int len = s.length();
		int sum = 0;
		int prev = 0;
		
		for (int i = len - 1; i >= 0; i--) {
			
			int current = getIntegerVal(s.charAt(i));
			
			if (prev > current) {
				sum -= current;
			} else {
				sum += current;
			}
			prev = current;
		}
		return sum;
	}

	private int getIntegerVal(char c) {
		int num = 0;
		switch (c) {
		case 'I':
			num = 1;
			break;
		case 'V':
			num = 5;
			break;
		case 'X':
			num = 10;
			break;
		case 'L':
			num = 50;
			break;
		case 'C':
			num = 100;
			break;
		case 'D':
			num = 500;
			break;
		case 'M':
			num = 1000;
			break;
		default:
			num = 0;
			break;
		}
		return num;
	}

	/*
	 *  Solution 2 using MAP
	 */
	public int romanToInt_2(String s) {
		Map<Character, Integer> romanValMap = new HashMap<>();
		romanValMap.put('I', 1);
		romanValMap.put('V', 5);
		romanValMap.put('X', 10);
		romanValMap.put('L', 50);
		romanValMap.put('C', 100);
		romanValMap.put('D', 500);
		romanValMap.put('M', 1000);

		char[] sarr = s.toCharArray();

		int len = sarr.length;

		int sum = 0;
		char current, next = sarr[0];

		for (int i = 0; i < len - 1; i++) {
			next = sarr[i + 1];
			current = sarr[i];
			sum += romanValMap.get(current); // add everytime
			switch (current) {
			case 'I':
				if (next == 'V' || next == 'X') {
					sum -= 2 * romanValMap.get(current); // since its already added remove twice the value
				}
				break;
			case 'X':
				if (next == 'L' || next == 'C') {
					sum -= 2 * romanValMap.get(current);
				}
				break;
			case 'C':
				if (next == 'D' || next == 'M') {
					sum -= 2 * romanValMap.get(current);
				}
				break;
			}
		}
		sum += romanValMap.get(next);
		return sum;
	}
}

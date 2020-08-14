package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/*
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 */
public class FizzBuzz {

	/*
	 * Time: O(N) Space: O(1)
	 */
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();

		for (int num = 1; num <= n; num++) {
			if (num % 3 == 0 && num % 5 == 0) {
				result.add("FizzBuzz");
			} else if (num % 3 == 0) {
				result.add("Fizz");
			} else if (num % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(Integer.toString(num));
			}
		}
		return result;
	}

	/*
	 * Time: O(N) Space: O(1)
	 */
	public List<String> fizzBuzz2(int n) {
		List<String> result = new ArrayList<>();

		for (int num = 1; num <= n; num++) {

			StringBuilder str = new StringBuilder();

			if (num % 3 == 0) {
				str.append("Fizz");
			}

			if (num % 5 == 0) {
				str.append("Buzz");
			}

			if (str.length() == 0) {
				str.append(Integer.toString(num));
			}

			result.add(str.toString());
		}
		return result;
	}
}

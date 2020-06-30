package com.leetcode.math;

/*
 * 556. Next Greater Element III
 * https://leetcode.com/problems/next-greater-element-iii/
 */
public class NextGreaterElement3 {

	public static void main(String[] args) {
		int n = 54321;
		NextGreaterElement3 nxt = new NextGreaterElement3();
		// System.out.println("Greatest element: " + nxt.nextGreaterElement(n));
		System.out.println("Greatest element: " + nxt.nextGreaterElement(n));
	}

	public int nextGreaterElement(int n) {

		char[] nChar = (n + "").toCharArray();
		int len = nChar.length;

		int i = len - 2;

		while (i >= 0 && nChar[i + 1] <= nChar[i]) {
			i--;
		}

		if (i < 0) {
			return -1;
		}

		int j = len - 1;

		while (j >= 0 && nChar[j] <= nChar[i]) {
			j--;
		}

		swap(nChar, i, j);

		reverse(nChar, i + 1);

		try {
			return Integer.parseInt(new String(nChar));
		} catch (Exception e) {
			return -1;
		}
	}

	private void swap(char arr[], int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void reverse(char arr[], int start) {
		int end = arr.length - 1;

		while (start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
}

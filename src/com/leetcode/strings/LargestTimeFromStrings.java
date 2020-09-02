package com.leetcode.strings;

/*
 * 949. Largest Time for Given Digits
 * https://leetcode.com/problems/largest-time-for-given-digits/
 * 
 * Time: O(1) - Since input array length is always 4
 * Space: O(1) 
 */
public class LargestTimeFromStrings {

	private int maxTime = -1;

	public String largestTimeFromDigits(int[] A) {
		this.maxTime = -1;
		permutate(A, 0);

		if (this.maxTime == -1) {
			return "";
		} else {
			return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
		}
	}

	private void permutate(int[] arr, int start) {
		if (start == arr.length) {
			this.buildTime(arr);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			this.swap(arr, start, i);
			this.permutate(arr, start + 1);
			this.swap(arr, start, i);
		}
	}

	private void buildTime(int[] arr) {
		int hour = arr[0] * 10 + arr[1];
		int min = arr[2] * 10 + arr[3];

		if (hour < 24 && min < 60) {
			this.maxTime = Math.max(this.maxTime, hour * 60 + min);
		}
	}

	private void swap(int arr[], int i, int j) {
		if (i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public static void main(String[] args) {
		int t[] = { 1, 2, 3, 4 };
		LargestTimeFromStrings lts = new LargestTimeFromStrings();
		System.out.println(lts.largestTimeFromDigits(t));
	}
}

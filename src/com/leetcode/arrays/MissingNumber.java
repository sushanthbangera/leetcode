package com.leetcode.arrays;

public class MissingNumber {

	/*
	 * Time: O(N)  Space: O(1)
	 */
	public int missingNumber(int[] nums) {
		int actualLen = nums.length;

		int sumOfNumbers = (actualLen * (actualLen + 1)) / 2;

		int sequenceSum = 0;
		for (int n : nums) {
			sequenceSum += n;
		}

		return sumOfNumbers - sequenceSum;
	}
	
	/*
	 * Time: O(N)  Space: O(1)
	 */
	public int missingNumber2(int[] nums) {
		int missingNum = nums.length;
		
		for (int i = 0; i < nums.length; i++) {
			missingNum ^= i ^ nums[i];
		}
		
		return missingNum;
	}
	
	public static void main(String[] args) {
		
		MissingNumber m = new MissingNumber();
		int nums[] = {6,8,4,2,3,5,7,0,1};
		System.out.println(m.missingNumber2(nums));
	}
}

package com.leetcode.math;

/*
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class NthUglyNumber {

	/*
	 * Time: O(n) Space: O(n)
	 */
	public int nthUglyNumber(int n) {
		
		if (n == 0 && n < 1) return 0;
		
		if (n == 1) return 1;
		
		int ugly[] = new int[n];
		ugly[0] = 1;
		
		int i2 = 0, i3 = 0, i5 = 0;
		
		int count = 1;
		
		int nextUglyNumber = 1, nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5;
		
		while (count < n) {
			
			nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
			ugly[count] = nextUglyNumber;
			
			if (nextUglyNumber == nextMultipleOf2) {
				i2 = i2 + 1;
				nextMultipleOf2 = ugly[i2] * 2;
			} 
			if (nextUglyNumber == nextMultipleOf3) {
				i3 = i3 + 1;
				nextMultipleOf3 = ugly[i3] * 3;
			} 
			if (nextUglyNumber == nextMultipleOf5) {
				i5 = i5 + 1;
				nextMultipleOf5 = ugly[i5] * 5;
			}
			
			count++;
		}
		return ugly[count - 1];
	}
	
	public static void main(String[] args) {
		int n = 10;
		NthUglyNumber nUgly = new NthUglyNumber();
		System.out.println("Nth Ugly No: " + nUgly.nthUglyNumber(n));
	}
}

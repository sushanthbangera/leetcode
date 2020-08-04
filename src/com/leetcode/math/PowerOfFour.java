package com.leetcode.math;

/*
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/
 */
public class PowerOfFour {
	
	/*
	 * Time: O(logn)  Space: O(1)
	 */
	public boolean isPowerOfFour(int num) {
		int count = 0;
		int temp = num & (num - 1); 
		
		if (temp == 0) { // 16 => 1 0 0 0 0 
			while (num != 0) {
				num = num >> 1;
				count++;
			}
			return (count - 1) % 2 == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		int num = 32;
		PowerOfFour pof = new PowerOfFour();
		System.out.println("Is power of 4: " + pof.isPowerOfFour(num));
	}
}

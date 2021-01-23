package com.leetcode.math.bitwise;

public class ReverseBits {

	public int reverseBits(int n) {

		int temp = n;
		int count = 0;
		
		while (n != 0) {
			n = n >> 1;
			count++;
		}
		
		int x = (int) Math.pow(2, count);
		
		return temp ^ (x - 1);
	}
	
	public static void main(String[] args) {
		
		int n = 13;
		ReverseBits rb = new ReverseBits();
		System.out.println(rb.reverseBits(n));
	}
}

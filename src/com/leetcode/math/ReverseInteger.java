package com.leetcode.math;

public class ReverseInteger {

	public int reverse(int x) {
		long rev = 0;

		while (x != 0) {
			int rem = x % 10;
			x /= 10;
			rev = rev * 10 + rem;
		}
		if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) rev;
	}

	public int reverse_2(int x) {
		int rev = 0;

		while (x != 0) {
			int rem = x % 10;
			x /= 10;

			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE && rem > 7)) {
				return 0;
			}
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE && rem < -8)) {
				return 0;
			}
			rev = rev * 10 + rem;
		}
		return rev;
	}

	public static void main(String[] args) {
		int x = 123;
		ReverseInteger revInt = new ReverseInteger();
		System.out.println(revInt.reverse(x));
		System.out.println(revInt.reverse_2(x));
	}
}

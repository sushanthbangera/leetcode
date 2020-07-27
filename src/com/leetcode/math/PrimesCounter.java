package com.leetcode.math;

/*
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/
 */
public class PrimesCounter {

	/*
	 * run time is twice the value of n Time: O(N) Space: O(N)
	 */
	public int countPrimes(int n) {

		// considering non primes since O(n) is required to make each index true;
		boolean nonPrimes[] = new boolean[n];

		for (int i = 2; i * i < n; i++) {
			if (!nonPrimes[i]) {
				for (int j = i; i * j < n; j++) {
					nonPrimes[j * i] = true;
				}
			}
		}

		int primeCount = 0;
		for (int k = 2; k < n; k++) {
			if (!nonPrimes[k]) {
				primeCount++;
			}
			if (!nonPrimes[k] && n % k == 0) {
				System.out.println("The prime factor is: " + k);

			}

		}
		return primeCount;
	}

	/*
	 * run time is thrice the value of n to set default value as true Time: O(N)
	 * Space: O(N)
	 */
	public int countPrimes2(int n) {

		boolean primes[] = new boolean[n];

		// make all numbers as prime
		for (int i = 0; i < n; i++) {
			primes[i] = true;
		}

		for (int i = 2; i * i < n; i++) {
			// if a number is prime, it's multiples will be divided
			// by the number and hence it wont be prime
			if (primes[i]) {
				for (int j = i; i * j < n; j++) {
					primes[j * i] = false;
				}
			}
		}

		int primeCount = 0;
		for (int k = 2; k < n; k++) {
			if (primes[k]) {
				primeCount++;
			}
		}
		return primeCount;
	}

	public static void main(String[] args) {
		int n = 1000;
		PrimesCounter pc = new PrimesCounter();
		System.out.println("No. of Primes: " + pc.countPrimes(n));
	}
}

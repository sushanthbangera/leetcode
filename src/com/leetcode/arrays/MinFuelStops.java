package com.leetcode.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 871. Minimum Number of Refueling Stops
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 */
public class MinFuelStops {

	/*
	 * Time: O(n^2) Space: O(n) for dp
	 */
	public int minRefuelStops(int target, int startFuel, int[][] stations) {

		int N = stations.length;

		long dp[] = new long[N + 1];

		dp[0] = startFuel;

		for (int i = 0; i < N; i++) {
			for (int t = i; t >= 0; t--) {
				// The farthest you can travel by fueling at i'th station
				if (dp[t] >= stations[i][0]) {
					dp[t + 1] = Math.max(dp[t + 1], dp[t] + (long) stations[i][1]);
				}
			}
		}

		for (int i = 0; i <= N; i++) {
			if (dp[i] >= target)
				return i;
		}

		return -1;
	}

	/*
	 * Time: O(NlogN) Space: O(N) for maxHeap
	 */
	public int minRefuelStops2(int target, int startFuel, int[][] stations) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int fuelStops = 0, prevLocation = 0;
		
		int availableFuel = startFuel;

		for (int[] station : stations) {
			int location = station[0];
			int capacity = station[1];

			availableFuel -= (location - prevLocation);

			while (!maxHeap.isEmpty() && availableFuel < 0) {
				availableFuel += maxHeap.poll();
				fuelStops++;
			}

			if (availableFuel < 0) {
				return -1;
			}

			maxHeap.offer(capacity);
			prevLocation = location;
		}

		// Repeat body for station = (target, inf)

		{
			availableFuel -= target - prevLocation;

			while (!maxHeap.isEmpty() && availableFuel < 0) {
				availableFuel += maxHeap.poll();
				fuelStops++;
			}

			if (availableFuel < 0) {
				return -1;
			}
		}

		return fuelStops;
	}

	public static void main(String[] args) {
		MinFuelStops mfs = new MinFuelStops();
		int stations[][] = { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } };
		int startFuel = 10;
		int target = 100;

		System.out.println("Min Fuel Stops: " + mfs.minRefuelStops(target, startFuel, stations));
		
		System.out.println("Min Fuel Stops: " + mfs.minRefuelStops2(target, startFuel, stations));
	}
}

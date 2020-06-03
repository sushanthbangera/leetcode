package com.leetcode.trees;

/*
 *  Amazon | OA 2019 | Min Cost to Connect Ropes
 *  
 *  72 https://leetcode.com/problems/minimum-cost-to-connect-sticks
 */
public class MinRopeCost {

	public static void main(String[] args) {
		int ropes[] = { 4, 3, 2, 6 };
		System.out.println("Minimum Cost = " + getMinimumRopeCost(ropes));
	}

	public static int getMinimumRopeCost(int[] ropes) {

		int minCost = 0;
		MinHeap minHeap = new MinHeap(ropes);

		while (!minHeap.isSizeOne()) {

			int first = minHeap.extract();
			int second = minHeap.extract();
			int value = first + second;

			minCost += value;
			minHeap.insertInHeap(value);
		}
		return minCost;
	}

}

package com.leetcode.arrays;

/*
 * 274. H-Index
 * https://leetcode.com/problems/h-index/
 */
public class HIndex {

	/*
	 * Time: O(N)  Space: O(N)
	 */
	public int hIndex(int[] citations) {

		if (citations == null || citations.length == 0)
			return 0;

		int n = citations.length;

		int bucket[] = new int[n + 1];

		for (int c : citations) {
			if (c >= n) {
				//for any paper with larger number of reference than n, 
				//put in the n-th bucket.
				bucket[n]++;
			} else {
				//for any paper with reference corresponding to the index of the bucket, 
				//increment the count for that bucket
				bucket[c]++;
			}
		}

		int count = 0;
		for (int i = n; i >= 0; i--) {
			//whenever the total count exceeds the index of the bucket, 
			//meaning that we have the index number of papers that have 
			//reference greater than or equal to the index. Which will be our h-index
			count += bucket[i];
			if (count >= i) {
				return i;
			}
		}

		return 0;
	}
}

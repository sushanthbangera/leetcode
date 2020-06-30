package com.leetcode.arrays;

import java.util.HashMap;
import java.util.PriorityQueue;

import com.leetcode.utils.ArrayUtils;

/*
 *  347. Top K Frequent Elements
 *  https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentNumbers {

	/*
	 * MaxHeap is used to store all the elements
	 * if you need it in frequency order
	 */
	public int[] topKFrequent(int[] nums, int k) {
		int top[] = new int[k];

		HashMap<Integer, Integer> countMap = new HashMap<>();
		for (int i : nums) {
			countMap.put(i, countMap.getOrDefault(i, 0) + 1);
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> countMap.get(b) - countMap.get(a));
		maxHeap.addAll(countMap.keySet());
		
		int i = 0;
		while (!maxHeap.isEmpty() && i < k) {
			top[i++] = maxHeap.poll();
		}
		return top;
	}
	
	/*
	 * MinHeap is used to store only K elements
	 * Space used is less and items are printed from lowest to highest frequency
	 */
	public int[] topKFrequent2(int[] nums, int k) {
		int top[] = new int[k];

		HashMap<Integer, Integer> countMap = new HashMap<>();
		for (int i : nums) {
			countMap.put(i, countMap.getOrDefault(i, 0) + 1);
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)-> countMap.get(a) - countMap.get(b));
		
		for (Integer key: countMap.keySet()) {
			minHeap.offer(key);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		int i = 0;
		while (!minHeap.isEmpty()) {
			top[i++] = minHeap.poll();
		}
		return top;
	}
	
	public static void main(String[] args) {
		
		int nums[] = {1,1,1,1,2,2,2,2,2,2,3};
		int k = 2;
		
		TopKFrequentNumbers tk = new  TopKFrequentNumbers();
		ArrayUtils.print(tk.topKFrequent(nums, k));
		ArrayUtils.print(tk.topKFrequent2(nums, k));
	}
}

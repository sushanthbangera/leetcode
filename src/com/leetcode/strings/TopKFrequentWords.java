package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 692. Top K Frequent Words
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {

	/*
	 * N - length of words and k top words
	 * 
	 * Frequency of each word: O(N) 
	 * Adding each word to heap in O(logk) and then pop from heap k times
	 * 
	 * k <= N  ---> O(Nlogk)
	 * 
	 * Time: O(Nlogk)
	 * Space: O(N)
	 */
	public List<String> topKFrequent(String[] words, int k) {

		List<String> resultList = new ArrayList<>();

		if (words == null || words.length == 0) {
			return resultList;
		}

		Map<String, Integer> freqMap = new HashMap<>();

		int len = words.length;

		for (int i = 0; i < len; i++) {
			freqMap.put(words[i], freqMap.getOrDefault(words[i], 0) + 1);
		}
		
		PriorityQueue<String> minHeap = new PriorityQueue<String>(
				(a, b) -> freqMap.get(a).equals(freqMap.get(b)) ? b.compareTo(a) : (freqMap.get(a) - freqMap.get(b)));

		// maintain only Top K frequent words - O(logk)
		for (String word : freqMap.keySet()) {
			minHeap.offer(word);
			if (minHeap.size() > k)
				minHeap.poll();
		}

		while (!minHeap.isEmpty()) {
			resultList.add(minHeap.poll());
		}
		Collections.reverse(resultList);
		return resultList;
	}
}

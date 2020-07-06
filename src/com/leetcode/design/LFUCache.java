package com.leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*
 * 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {

	private Map<Integer, Integer> cacheDataMap;

	private Map<Integer, Integer> freqMap;

	private Map<Integer, LinkedHashSet<Integer>> freqCacheDataMap;

	private int cacheSize;

	private int minFreq = -1;

	public LFUCache(int capacity) {
		cacheSize = capacity;
		cacheDataMap = new HashMap<>();
		freqMap = new HashMap<>();
		freqCacheDataMap = new HashMap<>();
		freqCacheDataMap.put(1, new LinkedHashSet<>());
	}

	public int get(int key) {

		if (!cacheDataMap.containsKey(key) || cacheSize == 0) {
			return -1;
		}

		int curKeyfreq = freqMap.get(key);
		freqMap.put(key, curKeyfreq + 1);

		freqCacheDataMap.get(curKeyfreq).remove(key);

		if (minFreq == curKeyfreq && freqCacheDataMap.get(curKeyfreq).size() == 0) {
			minFreq++;
		}

		if (!freqCacheDataMap.containsKey(curKeyfreq + 1)) {
			freqCacheDataMap.put(curKeyfreq + 1, new LinkedHashSet<>());
		}

		freqCacheDataMap.get(curKeyfreq + 1).add(key);
		return cacheDataMap.get(key);
	}

	public void put(int key, int value) {

		if (cacheSize <= 0)
			return;

		if (cacheDataMap.containsKey(key)) {
			cacheDataMap.put(key, value);
			get(key); // to increase freq
			return;
		}

		if (cacheDataMap.size() == cacheSize) {
			int evict = freqCacheDataMap.get(minFreq).iterator().next();
			freqCacheDataMap.get(minFreq).remove(evict);

			cacheDataMap.remove(evict);
			freqMap.remove(evict);
		}

		cacheDataMap.put(key, value);
		minFreq = 1;
		freqMap.put(key, 1);
		freqCacheDataMap.get(1).add(key);
	}

	public static void main(String[] args) {

		LFUCache cache = new LFUCache(2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);

		int returnVal = cache.get(1); // returns 1
		System.out.println("returnVal: " + returnVal);

		cache.put(3, 3); // evicts key 2

		returnVal = cache.get(2); // returns -1 (not found)
		System.out.println("returnVal: " + returnVal);

		returnVal = cache.get(3); // returns 3.
		System.out.println("returnVal: " + returnVal);

		cache.put(4, 4); // evicts key 1.

		returnVal = cache.get(1); // returns -1 (not found)
		System.out.println("returnVal: " + returnVal);

		returnVal = cache.get(3); // returns 3
		System.out.println("returnVal: " + returnVal);

		returnVal = cache.get(4); // returns 4
		System.out.println("returnVal: " + returnVal);
	}
}

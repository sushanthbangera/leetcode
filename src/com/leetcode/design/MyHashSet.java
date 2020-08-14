package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/*
 * 705. Design HashSet
 * https://leetcode.com/problems/design-hashset/submissions/
 */
public class MyHashSet {

	private static Integer constant = 12345;
	private Map<Integer, Integer> set;

	/** Initialize your data structure here. */
	public MyHashSet() {
		set = new HashMap<>();
	}

	public void add(int key) {
		set.put(key, constant);
	}

	public void remove(int key) {
		set.remove(key);
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return set.containsKey(key);
	}
}

package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 */
public class CombinationIterator {

	private Queue<String> combinations;

	public CombinationIterator(String characters, int combinationLength) {
		this.combinations = new LinkedList<>();
		createCombinations(characters, 0, "", combinationLength, combinations);
	}

	public void createCombinations(String characters, int start, String soFar, int k, Queue<String> queue) {
		if (k == 0) {
			queue.add(soFar);
			return;
		}

		for (int i = start; i < characters.length(); i++) {
			createCombinations(characters, i + 1, soFar + characters.charAt(i), k - 1, queue);
		}
	}

	public String next() {
		return combinations.poll();
	}

	public boolean hasNext() {
		return !combinations.isEmpty();
	}

	public static void main(String[] args) {
		CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

		System.out.println(iterator.next()); // returns "ab"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "ac"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "bc"
		System.out.println(iterator.hasNext()); // returns false
	}
}

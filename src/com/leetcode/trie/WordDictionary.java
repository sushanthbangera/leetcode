package com.leetcode.trie;

/*
 * 211. Add and Search Word - Data structure design
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class WordDictionary {

	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	}

	private TrieNode root;

	/** Initialize data structure. */
	public WordDictionary() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.isWord = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return match(word.toCharArray(), 0, root);
	}

	private boolean match(char[] chars, int index, TrieNode node) {
		if (chars.length == index)
			return node.isWord;

		if (chars[index] == '.') {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null && match(chars, index + 1, node.children[i])) {
					return true;
				}
			}
		} else {
			return node.children[chars[index] - 'a'] != null
					&& match(chars, index + 1, node.children[chars[index] - 'a']);
		}
		return false;
	}

	public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		String word = "ask";

		obj.addWord(word);
		System.out.println("Word " + word + " is " + (obj.search(word) ? "found" : "not found"));

		word = ".sk";
		System.out.println("Word " + word + " is " + (obj.search(word) ? "found" : "not found"));

		word = "sk";
		System.out.println("Word " + word + " is " + (obj.search(word) ? "found" : "not found"));
	}
}

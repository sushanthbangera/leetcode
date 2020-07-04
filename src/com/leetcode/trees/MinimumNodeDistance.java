package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/*
 * 783. Minimum Distance Between BST Nodes
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinimumNodeDistance {

	private Integer min = Integer.MAX_VALUE;

	private Integer prev = null;

	/*
	 * Method which uses the instance variables
	 * Time: O(n) and Space: O(h)
	 */
	public int minDiffInBST(TreeNode root) {
		inOrder(root);
		return min;
	}

	private void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;
		inOrder(root.right);
	}
	
	/*
	 * Time: O(n) and Space: O(n)
	 */
	public int minDiffInBSTList(TreeNode root) {
		
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		
		Integer min = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			min = Math.min(min, list.get(i) - list.get(i - 1));
		}
		return min;
	}
	
	private void inOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}
	
}

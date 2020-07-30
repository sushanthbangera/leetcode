package com.leetcode.trees;

import java.util.HashSet;
import java.util.Set;

/*
 * 671. Second Minimum Node In a Binary Tree
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class SecondMinimum {

	/*
	 * Time: O(n)  Space: O(n) 
	 */
	public int findSecondMinimumValue(TreeNode root) {
		Set<Integer> set = new HashSet<>();
		dfs(root, set);

		int min = root.val;
		long result = Long.MAX_VALUE;
		for (int n : set) {
			if (n > min && n < result) {
				result = n;
			}
		}
		return result < Long.MAX_VALUE ? (int) result : -1;
	}

	private void dfs(TreeNode root, Set<Integer> set) {
		if (root == null)
			return;

		set.add(root.val);
		dfs(root.left, set);
		dfs(root.right, set);
	}

	int minVal;
	long result = Long.MAX_VALUE;

	/*
	 * Less space since we dont have HashSet used here
	 * Time: O(n)  Space: O(n) - call stack O(h) ~ O(n)
	 */
	public int findSecondMinimumValue2(TreeNode root) {
		minVal = root.val;
		dfs(root);
		return result < Long.MAX_VALUE ? (int) result : -1;
	}

	private void dfs(TreeNode root) {
		if (root != null) {
			if (root.val > minVal && root.val < result) {
				result = root.val;
			} else if (root.val == minVal) {
				dfs(root.left);
				dfs(root.right);
			}
		}
	}

}

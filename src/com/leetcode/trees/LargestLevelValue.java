package com.leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * 515. Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class LargestLevelValue {

	public List<Integer> largestValues(TreeNode root) {

		List<Integer> resultList = new ArrayList<>();

		if (root == null)
			return resultList;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		Integer maxVal = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {

			int size = queue.size();

			while (size-- > 0) {

				TreeNode node = queue.poll();

				maxVal = Math.max(maxVal, node.val);

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}

			resultList.add(maxVal);
			maxVal = Integer.MIN_VALUE;

		}
		return resultList;
	}
}

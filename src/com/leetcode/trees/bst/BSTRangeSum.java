package com.leetcode.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.trees.TreeNode;

/*
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class BSTRangeSum {

	public int rangeSumBST(TreeNode root, int L, int R) {

		int sum = 0;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			if (node.val >= L && node.val <= R) {
				sum += node.val;
			}

			if (node.left != null && node.val > L) {
				queue.add(node.left);
			}

			if (node.right != null && node.val < R) {
				queue.add(node.right);
			}
		}
		return sum;
	}

	private int sum = 0;
	
	public int rangeSumBST2(TreeNode root, int L, int R) {
		sum = 0;
		dfsRangeSumBST(root, L, R);
		return sum;
	}
	
	private void dfsRangeSumBST(TreeNode root, int L, int R) {
		
		if (root == null) {
			return;
		}
		
		if (root.val >= L && root.val <= R) {
			sum += root.val;
		}
		
		if (root.val > L) {
			dfsRangeSumBST(root.left, L, R);
		}
		
		if (root.val < R) {
			dfsRangeSumBST(root.right, L, R);
		}
	}

	
}

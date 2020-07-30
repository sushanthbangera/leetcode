package com.leetcode.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;

import com.leetcode.trees.TreeNode;

/*
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
 */
public class KthSmallestInBST {

	/*
	 * Time: O(n) Space: O(n)
	 */
	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> list = inorder(root, new ArrayList<Integer>());
		return list.get(k - 1);
	}

	public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
		if (root == null)
			return arr;

		inorder(root.left, arr);
		arr.add(root.val);
		inorder(root.right, arr);
		return arr;
	}

	/*
	 * Time: O(h + k) -> h is trees height. if balanced tree its O(logn + k). If
	 * completlely unbalanced O(n + k) where all elements are in the left.
	 * 
	 * Space: O(h) for stack. O(n) in skewed tree and O(logn) for balanced tree.
	 */
	public int kthSmallest2(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		while (true) {

			while (root != null) {
				stack.add(root);
				root = root.left;
			}

			root = stack.removeLast();

			if (--k == 0)
				return root.val;

			root = root.right;
		}
	}
}

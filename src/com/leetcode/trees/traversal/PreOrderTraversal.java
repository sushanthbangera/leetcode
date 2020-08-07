package com.leetcode.trees.traversal;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.trees.TreeNode;

/*
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class PreOrderTraversal {

	/*
	 * Time: O(n) Space: O(n)
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preOrderTraversal(root, list);
		return list;
	}

	private void preOrderTraversal(TreeNode root, List<Integer> list) {
		if (root == null)
			return;

		list.add(root.val);
		preOrderTraversal(root.left, list);
		preOrderTraversal(root.right, list);
	}
}

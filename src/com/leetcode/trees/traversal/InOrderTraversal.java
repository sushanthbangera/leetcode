package com.leetcode.trees.traversal;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.trees.TreeNode;

/*
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class InOrderTraversal {

	/*
	 * Time: O(n) Space: O(n)
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inOrderTraversal(root, list);
		return list;
	}

	private void inOrderTraversal(TreeNode root, List<Integer> list) {
		if (root == null)
			return;

		inOrderTraversal(root.left, list);
		list.add(root.val);
		inOrderTraversal(root.right, list);
	}
}

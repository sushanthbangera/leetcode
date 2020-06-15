package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagTreeTraversal {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> zigzagList = new ArrayList<>();

		if (root == null) {
			return zigzagList;
		}

		Stack<TreeNode> currentLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();
		boolean isLeftToRight = true;

		currentLevel.push(root);

		List<Integer> currentLevelNodes = new ArrayList<>();

		while (!currentLevel.isEmpty()) {

			TreeNode n = currentLevel.pop();
			currentLevelNodes.add(n.val);

			if (isLeftToRight) {
				if (n.left != null) {
					nextLevel.push(n.left);
				}
				if (n.right != null) {
					nextLevel.push(n.right);
				}
			} else {
				if (n.right != null) {
					nextLevel.push(n.right);
				}
				if (n.left != null) {
					nextLevel.push(n.left);
				}
			}

			if (currentLevel.isEmpty()) {
				isLeftToRight = !isLeftToRight;
				Stack<TreeNode> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
				zigzagList.add(currentLevelNodes);
				currentLevelNodes = new ArrayList<>();
			}
		}
		return zigzagList;
	}
}

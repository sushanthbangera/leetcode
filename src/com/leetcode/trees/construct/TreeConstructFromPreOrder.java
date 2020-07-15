package com.leetcode.trees.construct;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.trees.TreeNode;

/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class TreeConstructFromPreOrder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		int len = inorder.length;
		Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			inOrderMap.put(inorder[i], i);
		}
		PreIndex pIndex = new PreIndex();
		pIndex.preIndex = 0;
		return buildTreeUtil(inorder, preorder, 0, len - 1, pIndex, inOrderMap);
	}

	private TreeNode buildTreeUtil(int[] inorder, int[] preorder, int strIndex, int endIndex, PreIndex pIndex,
			Map<Integer, Integer> inOrderMap) {

		if (strIndex > endIndex)
			return null;

		int curr = preorder[pIndex.preIndex];
		pIndex.preIndex++;
		TreeNode node = new TreeNode(curr);

		if (strIndex == endIndex) {
			return node;
		}

		int inIndex = inOrderMap.get(curr);

		node.left = buildTreeUtil(inorder, preorder, strIndex, inIndex - 1, pIndex, inOrderMap);

		node.right = buildTreeUtil(inorder, preorder, inIndex + 1, endIndex, pIndex, inOrderMap);

		return node;
	}

	private class PreIndex {
		int preIndex;
	}
}

package com.leetcode.trees.construct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leetcode.trees.PreOrderTraversal;
import com.leetcode.trees.TreeNode;

/*
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class TreeConstructFromPostInorder {
	
	private class PostIndex {
		int postIndex;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		int len = inorder.length;
		
		Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			inOrderMap.put(inorder[i], i);
		}
		PostIndex pIndex = new PostIndex();
		pIndex.postIndex = len - 1;
		return buildTreeUtil(inorder, postorder, 0, len - 1, pIndex, inOrderMap);
	}

	private TreeNode buildTreeUtil(int[] inorder, int[] postorder, int strIndex, int endIndex, PostIndex pIndex,
			Map<Integer, Integer> inOrderMap) {

		if (strIndex > endIndex)
			return null;

		int curr = postorder[pIndex.postIndex];
		TreeNode node = new TreeNode(curr);
		pIndex.postIndex--;

		if (strIndex == endIndex) {
			return node;
		}

		int inIndex = inOrderMap.get(curr);

		node.right = buildTreeUtil(inorder, postorder, inIndex + 1, endIndex, pIndex, inOrderMap);

		node.left = buildTreeUtil(inorder, postorder, strIndex, inIndex - 1, pIndex, inOrderMap);

		return node;
	}
	
	public static void main(String[] args) {
		
		int inorder[] = {9, 3, 15, 20, 7};
		int postorder[] = {9, 15, 7, 20, 3};
		
		TreeConstructFromPostInorder cbt = new TreeConstructFromPostInorder();
		TreeNode resultNode = cbt.buildTree(inorder, postorder);
		
		PreOrderTraversal po = new PreOrderTraversal();
		List<Integer> list = po.preorderTraversal(resultNode);
		
		System.out.println(list.toString());
		
	}
}

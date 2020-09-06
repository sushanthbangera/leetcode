package com.leetcode.trees.bst;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.trees.TreeNode;

/*
 * 1305. All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */
public class GetAllElements {

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<>();
		inOrderTraversal(root1, list1);
		List<Integer> list2 = new ArrayList<>();
		inOrderTraversal(root2, list2);

		int i = 0, j = 0;

		List<Integer> resultList = new ArrayList<>();

		while (i < list1.size() || j < list2.size()) {
			int num1 = i < list1.size() ? list1.get(i) : 100001;
			int num2 = j < list2.size() ? list2.get(j) : 100001;

			if (num1 < num2) {
				resultList.add(num1);
				i++;
			} else {
				resultList.add(num2);
				j++;
			}
		}

		return resultList;
	}

	private void inOrderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left, list);
		list.add(root.val);
		inOrderTraversal(root.right, list);
	}
}

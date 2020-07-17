package com.leetcode.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 1110. Delete Nodes And Return Forest
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class DeleteNodesReturnForest {

	/*
	 * Time: O(N)   Space: O(N) - for Call Stack and HashSet O(2N) ~ O(N)
	 */
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		List<TreeNode> remainingNodes = new ArrayList<>();
		Set<Integer> deletelist = new HashSet<>();
		for (int d : to_delete) {
			deletelist.add(d);
		}

		removeNodes(root, deletelist, remainingNodes);
		if (!deletelist.contains(root.val)) {
			remainingNodes.add(root);
		}
		return remainingNodes;
	}

	private TreeNode removeNodes(TreeNode root, Set<Integer> delList, List<TreeNode> remainingNodes) {
		if (root == null) {
			return null;
		}
		root.left = removeNodes(root.left, delList, remainingNodes);
		root.right = removeNodes(root.right, delList, remainingNodes);

		if (delList.contains(root.val)) {
			if (root.left != null) {
				remainingNodes.add(root.left);
			}
			if (root.right != null) {
				remainingNodes.add(root.right);
			}
			return null;
		}
		return root;
	}

}

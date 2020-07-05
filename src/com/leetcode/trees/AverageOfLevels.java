package com.leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * 637. Average of Levels in Binary Tree
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevels {

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> resultList = new ArrayList<>();

		if (root == null)
			return resultList;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		Double elementCount = 0.0;
		Double levelSum = 0.0;

		while (!queue.isEmpty()) {

			int size = queue.size();

			while (size-- > 0) {

				TreeNode node = queue.poll();
				elementCount += 1;
				levelSum += node.val;

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}

			resultList.add(levelSum / elementCount);
			levelSum = 0.0;
			elementCount = 0.0;
		}
		return resultList;
	}
}

package com.leetcode.trees.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

import com.leetcode.trees.TreeNode;

/*
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class VerticalOrderTraversal {

	/*
	 * Using TreeMap and TreeSet
	 */
	public List<List<Integer>> verticalTraversal(TreeNode root) {

		Map<Integer, TreeSet<int[]>> map = new TreeMap<>();
		List<List<Integer>> resultList = new LinkedList<>();

		dfs(root, 0, 0, map);

		for (int i : map.keySet()) {
			List<Integer> list = new LinkedList<>();
			for (int[] j : map.get(i))
				list.add(j[0]);

			resultList.add(list);
		}
		return resultList;
	}

	private void dfs(TreeNode root, int order, int level, Map<Integer, TreeSet<int[]>> map) {
		if (root == null)
			return;
		if (!map.containsKey(order))
			map.put(order, new TreeSet<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

		map.get(order).add(new int[] { level, root.val });
		dfs(root.left, order - 1, level + 1, map);
		dfs(root.right, order + 1, level + 1, map);
	}

	/*
	 *  Using TreeMap and PriorityQueue
	 */
	public List<List<Integer>> verticalTraversal2(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<>();
		
		// Treemap for the order of horizontal Distances
		Map<Integer, PriorityQueue<Pair>> map = new TreeMap<>();
		dfs(root, map, 0, 0);

		for (Map.Entry<Integer, PriorityQueue<Pair>> m : map.entrySet()) {

			List<Integer> list = new ArrayList<>();
			PriorityQueue<Pair> q = m.getValue();

			while (!q.isEmpty()) {
				list.add(q.remove().node.val);
			}
			resultList.add(list);
		}

		return resultList;
	}

	private void dfs(TreeNode node, Map<Integer, PriorityQueue<Pair>> map, int hd, int level) {

		if (node == null) {
			return;
		}

		PriorityQueue<Pair> que = null;

		if (map.containsKey(hd)) {
			que = map.get(hd);
		} else {
			que = new PriorityQueue<>((a, b) -> (a.level == b.level ? a.node.val - b.node.val : a.level - b.level));
		}

		que.add(new Pair(node, hd, level));
		map.put(hd, que);

		dfs(node.left, map, hd - 1, level + 1);
		dfs(node.right, map, hd + 1, level + 1);
	}

	public class Pair {

		TreeNode node;

		int hd;

		int level;

		Pair(TreeNode node, int hd, int level) {
			this.node = node;
			this.hd = hd;
			this.level = level;
		}
	}

}

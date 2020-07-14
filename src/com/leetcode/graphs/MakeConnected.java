package com.leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * 1319. Number of Operations to Make Network Connected
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
public class MakeConnected {

	public int makeConnected(int n, int[][] connections) {
		
		if (connections.length < n - 1) {
            return -1; // There are not enough cables.
        }

		Map<Integer, Set<Integer>> graph = new HashMap<>();
		buildGraph(connections, graph);

		Set<Integer> visited = new HashSet<>();

		int groupcount = 0;
		for (int i = 0; i < n; ++i) {
			if (visited.contains(i)) {
				continue;
			}
			groupcount++;

			visited.add(i);

			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			while (!queue.isEmpty()) {
				int node = queue.poll();

				Set<Integer> nextset = graph.get(node);
				if (null == nextset)
					continue;
				for (int next : nextset) {
					if (!visited.contains(next)) {
						queue.add(next);
						visited.add(next);
					}
				}
			}
		}

		return groupcount - 1;
	}

	private void buildGraph(int[][] connections, Map<Integer, Set<Integer>> graph) {

		for (int[] con : connections) {
			int src = con[0];
			int dest = con[1];

			Set<Integer> destList = graph.getOrDefault(src, new HashSet<>());
			destList.add(dest);
			graph.put(src, destList);

			Set<Integer> srcList = graph.getOrDefault(dest, new HashSet<>());
			;
			srcList.add(src);
			graph.put(dest, srcList);
		}
	}
}

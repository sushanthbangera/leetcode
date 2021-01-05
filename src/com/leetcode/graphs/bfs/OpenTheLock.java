package com.leetcode.graphs.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 752. Open the Lock
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {

	public int openLock(String[] deadends, String target) {

		Set<String> visited = new HashSet<>(Arrays.asList(deadends));

		Queue<String> queue = new LinkedList<>();

		queue.add("0000");

		int moves = -1; // adding "0000" is the 0th move

		while (!queue.isEmpty()) {
			moves++;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String curNode = queue.poll();
				if (curNode.equals(target)) {
					return moves;
				}

				if (visited.contains(curNode)) {
					continue;
				}

				visited.add(curNode);
				queue.addAll(getNextNodes(curNode));
			}
		}
		return -1;
	}

	public List<String> getNextNodes(String curNode) {
		List<String> nextNodes = new LinkedList<>();
		for (int i = 0; i < curNode.length(); i++) {
			String upNode = curNode.substring(0, i) + (curNode.charAt(i) == '9' ? 0 : curNode.charAt(i) - '0' + 1)
					+ curNode.substring(i + 1);
			String downNode = curNode.substring(0, i) + (curNode.charAt(i) == '0' ? 9 : curNode.charAt(i) - '0' - 1)
					+ curNode.substring(i + 1);
			nextNodes.add(upNode);
			nextNodes.add(downNode);
		}
		return nextNodes;
	}
}

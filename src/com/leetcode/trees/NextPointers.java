package com.leetcode.trees;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class NextPointers {

	/*
	 * Time: O(N)  Space: O(N)
	 */
	public Node connect(Node root) {

		if (root == null) {
			return null;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();
			int i = 0;
			Node previous = null;

			while (i < size) {

				Node n = queue.poll();

				if (i > 0) {
					previous.next = n;
				}
				previous = n;

				if (n.left != null) {
					queue.add(n.left);
				}

				if (n.right != null) {
					queue.add(n.right);
				}
				i++;
			}

			previous.next = null;
		}
		return root;
	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

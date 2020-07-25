package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
 */
public class LinkedListClone {

	/*
	 * Run time is 3 times the length of the node Time: O(3N) ~ O(N) Space: O(N) for
	 * the resultNode
	 */
	public Node copyRandomList(Node head) {

		if (head == null)
			return null;

		Node node = head;

		while (node != null) {
			Node copiedNode = new Node(node.val);
			copiedNode.next = node.next;
			node.next = copiedNode;
			node = copiedNode.next;
		}

		node = head;
		Node result = head.next;

		while (node != null) {
			Node copiedNode = node.next;
			if (node.random != null) {
				copiedNode.random = node.random.next;
			}
			node = copiedNode.next;
		}

		node = head;

		while (node != null) {
			Node copiedNode = node.next;
			node.next = copiedNode.next;
			node = node.next;
			copiedNode.next = (node == null) ? null : node.next;
		}

		return result;
	}

	/*
	 * Extra Space for Map is used but iteration is only twice Time: O(2N) ~O(N)
	 * Space: O(2N) ~ O(N) for the resultNode and HashMap
	 */
	public Node copyRandomList2(Node head) {

		if (head == null)
			return null;

		Map<Node, Node> nodeMap = new HashMap<>();

		Node node = head;

		while (node != null) {
			Node copiedNode = new Node(node.val);
			nodeMap.put(node, copiedNode);
			node = node.next;
		}

		node = head;

		while (node != null) {
			Node copiedNode = nodeMap.get(node);
			copiedNode.next = nodeMap.get(node.next);
			copiedNode.random = nodeMap.get(node.random);
			node = node.next;
		}

		return nodeMap.get(head);
	}
}

class Node {

	int val;

	Node next;

	Node random;

	Node(int val) {
		this.val = val;
	}
}

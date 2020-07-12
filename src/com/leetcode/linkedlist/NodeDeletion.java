package com.leetcode.linkedlist;

/*
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class NodeDeletion {

	/*
	 * Time: O(1) Space: O(1)
	 */
	public void deleteNode(ListNode node) {
		if (node != null) {
			ListNode nextNode = node.next;
			node.val = nextNode.val;
			node.next = nextNode.next;
		}
	}
}

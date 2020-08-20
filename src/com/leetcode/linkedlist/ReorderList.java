package com.leetcode.linkedlist;

/*
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

	/*
	 * Time: O(N)  and Space O(1)
	 */
	public void reorderList(ListNode head) {

		if (head == null || head.next == null)
			return;

		ListNode fastNode = head;
		ListNode slowNode = head;
		ListNode prev = head;

		while (fastNode != null && fastNode.next != null) {
			prev = slowNode;
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}

		ListNode secNode = slowNode;
		prev.next = null;

		ListNode front = head;
		ListNode reversed = reverseNode(secNode);

		while (front != null) {

			ListNode temp1 = front.next;
			ListNode temp2 = reversed.next;

			front.next = reversed;

			if (temp1 != null) {
				reversed.next = temp1;
			}

			front = temp1;
			reversed = temp2;
		}

	}
	
	private ListNode reverseNode(ListNode listNode) {
		ListNode curNode = listNode;
		ListNode prevNode = null;

		while (curNode != null) {
			ListNode tempNode = curNode.next;
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = tempNode;
		}
		return prevNode;
	}

}

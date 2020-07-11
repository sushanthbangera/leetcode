package com.leetcode.linkedlist;

/*
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveElement {

	public ListNode removeElements(ListNode head, int val) {

		ListNode current = head;
		ListNode previous = null;

		while (current != null) {
			if (current.val == val) {
				if (previous != null) {
					previous.next = current.next;
					current = current.next;
				} else { // if the first element is equal to given value
					head = head.next;
					current = head;
				}
			} else {
				previous = current;
				current = current.next;
			}
		}
		return head;
	}
}

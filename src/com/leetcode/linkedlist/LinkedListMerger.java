package com.leetcode.linkedlist;

/*
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/submissions/detail/338360427/
 */
public class LinkedListMerger {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode mergedNode = new ListNode(0); // dummyHead
		ListNode newNode = null;
		ListNode currentNode = mergedNode;

		while (l1 != null || l2 != null) {

			if (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					newNode = new ListNode(l1.val);
					l1 = l1.next;
				} else {
					newNode = new ListNode(l2.val);
					l2 = l2.next;
				}
			} else if (l1 != null) {
				newNode = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				newNode = new ListNode(l2.val);
				l2 = l2.next;
			}
			
			currentNode.next = newNode;
			currentNode = currentNode.next;
		}

		return mergedNode.next; // skip the dummy head node
	}
}

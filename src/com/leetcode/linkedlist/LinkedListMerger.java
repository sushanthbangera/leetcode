package com.leetcode.linkedlist;

/*
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/submissions/detail/338360427/
 */
public class LinkedListMerger {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode mergedNode = null;
		ListNode newNode = null;
		ListNode currentNode = null;

		while (l1 != null && l2 != null) {

			if (l1.val <= l2.val) {
				newNode = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				newNode = new ListNode(l2.val);
				l2 = l2.next;
			}

			if (mergedNode != null) {
				currentNode.next = newNode;
				currentNode = currentNode.next;
			} else {
				mergedNode = newNode;
				currentNode = newNode;
			}
		}

		if (l1 != null || l2 != null) {
			l1 = l1 != null ? l1 : l2;
		}

		while (l1 != null) {
			newNode = new ListNode(l1.val);
			if (mergedNode != null) {
				currentNode.next = newNode;
				currentNode = currentNode.next;
			} else {
				mergedNode = newNode;
				currentNode = newNode;
			}
			l1 = l1.next;
		}

		return mergedNode;
	}
}

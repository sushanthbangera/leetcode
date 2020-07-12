package com.leetcode.linkedlist;

/*
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/submissions/
 */
public class CycleDetector {

	/*
	 * Time: O(n)   Space: O(1)
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr) {
				break;
			}
		}

		if (slowPtr != fastPtr) {
			return null;
		}

		while (head != slowPtr) {
			head = head.next;
			slowPtr = slowPtr.next;
		}
		return slowPtr;
	}
}

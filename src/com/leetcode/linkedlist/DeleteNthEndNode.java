package com.leetcode.linkedlist;

/*
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class DeleteNthEndNode {

	/*
	 * Time: O(N)  Space: O(1)
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy = new ListNode(-1); // to avoid edge cases with length 1 and 2
		dummy.next = head;

		ListNode fast = dummy;
		ListNode slow = dummy;

		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return dummy.next;
	}
}

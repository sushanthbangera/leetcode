package com.leetcode.linkedlist;

/*
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {

	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode curNode = dummy;
		
		while (curNode.next != null && curNode.next.next != null) {
			
			ListNode first = curNode.next;
			ListNode second = curNode.next.next;

			first.next = second.next;
			curNode.next = second;
		    curNode.next.next = first;
			curNode = curNode.next.next;
		}

		return dummy.next;
	}
}

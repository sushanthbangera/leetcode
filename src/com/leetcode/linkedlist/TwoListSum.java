package com.leetcode.linkedlist;

/*
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 */
public class TwoListSum {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode sumNode = new ListNode(0); // dummyNode
		int carry = 0, sum = 0;
		ListNode current = sumNode;
		
		while (l1 != null || l2 != null) {
			sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
			carry = sum / 10;
			
			current.next = new ListNode(sum % 10);
			current = current.next;
			
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		if(carry > 0) {
			current.next = new ListNode(carry);
	    }
		return sumNode.next; // skip the dummy Head Node
	}
}

package com.leetcode.linkedlist;

/*
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

	/*
	 * Iterative Approach
	 * Time: O(N)  Space: O(1)
	 */
	public ListNode reverseList(ListNode head) {

		ListNode current = head;
		ListNode previous = null;

		while (current != null) {
			ListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		return previous;
	}
	
	/*
	 * Recursive Approach
	 * Time: O(N) Space: O(N) for stack
	 */
	public ListNode reverseList2(ListNode head) {
	    if (head == null || head.next == null) return head; // returns for last but one Node
	    ListNode p = reverseList2(head.next); // this will get the tail node
	    // reversing the pointers
	    head.next.next = head; // [30 next] -> [40 next] = [30 next];
	    head.next = null; // [40 next] -> NULL
	    return p; // Always has the tail Node
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		
		head.print(head);
		System.out.println();
		
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode rev = rl.reverseList2(head);
		rev.print(rev);
	}
}

package com.leetcode.linkedlist;

import java.util.PriorityQueue;

/*
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class KListMergeSort {

	/*
	 * k sorted linked lists each of size n,
	 * 
	 * Time Complexity: O(n * k * log k).
	 * Insertion and deletion in a Min Heap requires log k time. 
	 * So the Overall time complexity is O(n * k * log k)
	 * 
	 * Auxiliary Space: O(k)
	 * k is the space required to store the priority queue
	 */
	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> q = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				q.add(lists[i]);
			}
		}
		
		ListNode fakeHead = new ListNode(-1);
		ListNode pnode = fakeHead;
		
		while (!q.isEmpty()) {
			ListNode currentNode = q.poll();
			if (currentNode.next != null) {
				q.add(currentNode.next);
			}
			currentNode.next = null;
			pnode.next = currentNode;
			pnode = currentNode;
		}
		return fakeHead.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}

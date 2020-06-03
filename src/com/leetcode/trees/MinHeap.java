package com.leetcode.trees;

/*
 * Array is populated from index 1
 */
public class MinHeap {

	int arr[];
	int sizeOfHeap;

	public MinHeap(int size) {
		arr = new int[size + 1];
		this.sizeOfHeap = 0;
	}

	public MinHeap(int[] a) {

		int len = a.length;
		arr = new int[len + 1];
		this.sizeOfHeap = 0;

		int i = 0;

		while (i < len) {
			insertInHeap(a[i]);
			i++;
		}
	}

	public boolean isEmpty() {
		return sizeOfHeap <= 0;
	}

	public boolean isSizeOne() {
		return sizeOfHeap == 1;
	}

	public void insertInHeap(int value) {
		System.out.println("Inserting value: " + value);
		arr[sizeOfHeap + 1] = value;
		sizeOfHeap++;
		heapifyBottomToTop(sizeOfHeap);
		levelOrder();
	}

	private void heapifyBottomToTop(int index) {

		if (index <= 1)
			return;

		int parent = index / 2;

		if (arr[parent] > arr[index]) {
			swap(index, parent);
		}
		heapifyBottomToTop(parent);
	}

	public int extract() {
		if (sizeOfHeap == 0) {
			return -1;
		} else {
			int extractedValue = arr[1];
			arr[1] = arr[sizeOfHeap];
			sizeOfHeap--;
			heapifyToptoBottom(1);
			System.out.println("Extracting value: " + extractedValue);
			levelOrder();
			return extractedValue;
		}
	}

	private void heapifyToptoBottom(int index) {

		int leftChild = index * 2;
		int rightChild = (index * 2) + 1;
		int smallestChildIndex = 0;

		if (sizeOfHeap < leftChild) { // there is no left child;
			return;
		} else if (sizeOfHeap == leftChild) {
			if (arr[index] > arr[leftChild]) {
				swap(index, leftChild);
			}
			return;
		} else {
			// if both children are present, get the smallest one
			smallestChildIndex = arr[leftChild] < arr[rightChild] ? leftChild : rightChild;

			if (arr[smallestChildIndex] < arr[index]) {
				swap(index, smallestChildIndex);
			}
		}
		heapifyToptoBottom(smallestChildIndex);
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void levelOrder() {
		for (int i = 1; i <= sizeOfHeap; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

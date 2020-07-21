package com.leetcode.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {

	public int leastInterval2(char[] tasks, int n) {

		int result = 0;
		int maxFreq = 0;
		int t[] = new int[26];

		for (int task : tasks) {
			t[task - 'A']++;
			maxFreq = Math.max(maxFreq, t[task - 'A']);
		}

		// A _ _ A _ _ A _ _ A _ _ A _ _ A.
		// different tasks should be running every n + 1 seconds
		result = (maxFreq - 1) * (n + 1);
		
		for (int i = 0; i < 26; i++) {
			if (t[i] == maxFreq) {
				result++;
			}
		}
		return Math.max(result, tasks.length);
	}

	public int leastInterval(char[] tasks, int n) {

		int result = 0;

		Map<Character, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < tasks.length; i++) {
			freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i], 0) + 1);
		}

		// maxheap to store tasks in decreasing order of their frequency
		PriorityQueue<Task> tq = new PriorityQueue<>((t1, t2) -> t2.count - t1.count);

		for (Character t : freqMap.keySet()) {
			tq.add(new Task(t, freqMap.get(t)));
		}

		while (!tq.isEmpty()) {

			List<Task> pastTasks = new ArrayList<>();

			// Iterate for n + 1 seconds
			for (int i = 0; i < n + 1; i++) {

				if (tq.isEmpty() && pastTasks.isEmpty()) {
					break;
				}

				if (!tq.isEmpty()) {
					Task t = tq.poll();
					t.count--;
					if (t.count > 0) {
						pastTasks.add(t);
					}
				}

				result++;
			}
			for (Task t : pastTasks) {
				tq.add(t);
			}

		}
		return result;
	}

	public static void main(String[] args) {

		char tasks[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 0;

		TaskScheduler ts = new TaskScheduler();
		System.out.println(ts.leastInterval2(tasks, n));
	}

}

class Task {

	Character name;

	Integer count;

	public Task(Character name, Integer count) {
		this.name = name;
		this.count = count;
	}

}

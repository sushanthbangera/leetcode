package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * 1450. Number of Students Doing Homework at a Given Time
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/submissions/
 */
public class BusyStudents {

	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

		int result = 0;

		for (int i = 0; i < startTime.length; i++) {
			result += (startTime[i] <= queryTime && endTime[i] >= queryTime) ? 1 : 0;
		}

		return result;
	}

	/*
	 * if there more than 1 query below approach can be followed Or to find out at
	 * which time max students where busy
	 */
	public int busyStudent2(int[] startTime, int[] endTime, int queryTime) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> secsMap = new HashMap<>();

		for (int i = 0; i < startTime.length; i++) {
			secsMap.put(startTime[i], secsMap.getOrDefault(startTime[i], 0) + 1);
			min = Math.min(min, startTime[i]);
			max = Math.max(max, startTime[i]);
		}

		for (int i = 0; i < endTime.length; i++) {
			secsMap.put(endTime[i] + 1, secsMap.getOrDefault(endTime[i] + 1, 0) - 1);
			min = Math.min(min, endTime[i]);
			max = Math.max(max, endTime[i]);
		}

		secsMap.put(0, 0);
		for (int i = 1; i <= max; i++) {
			secsMap.put(i, secsMap.getOrDefault(i, 0) + secsMap.get(i - 1));
		}

		if (queryTime <= 0 || queryTime > max) {
			return 0;
		}

		return secsMap.get(queryTime);
	}

	public static void main(String[] args) {
		BusyStudents bs = new BusyStudents();
		int startTime[] = { 1, 2, 3 };
		int endTime[] = { 3, 2, 7 };
		int queryTime = 4;

		System.out.println(bs.busyStudent(startTime, endTime, queryTime));
	}
}

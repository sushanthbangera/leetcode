package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> destMap = buildDestMap(numCourses, prerequisites);

		boolean[] courseTaken = new boolean[numCourses];
		Set<Integer> finishedTasks = new HashSet<>();

		for (int i = 0; i < numCourses; i++) {
			finishedTasks.clear();
			if (!DFS(destMap, i, courseTaken, finishedTasks)) {
				return false;
			}
		}
		return true;
	}

	private HashMap<Integer, List<Integer>> buildDestMap(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> destMap = new HashMap<>();
		int len = prerequisites.length;

		for (int i = 0; i < numCourses; i++) {
			destMap.put(i, new ArrayList<>());
		}

		for (int i = 0; i < len; i++) {
			int arr[] = prerequisites[i];
			destMap.get(arr[0]).add(arr[1]);
		}
		return destMap;
	}

	private boolean DFS(HashMap<Integer, List<Integer>> graph, int vertex, boolean[] courseTaken,
			Set<Integer> finishedTasks) {

		if (courseTaken[vertex]) {
			return true;
		}

		if (finishedTasks.contains(vertex)) {
			return false;
		}
		finishedTasks.add(vertex);

		List<Integer> destList = graph.get(vertex);

		for (Integer course : destList) {
			if (!courseTaken[course] || !finishedTasks.contains(course)) {
				if (!DFS(graph, course, courseTaken, finishedTasks)) {
					return false;
				}
			}
		}
		courseTaken[vertex] = true;
		return true;
	}
}

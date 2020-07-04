package com.leetcode.graphs;

/*
 * 997. Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/s
 */
public class TownJudgeFinder {
	/*
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int findJudge(int N, int[][] trust) {

		int srcMap[] = new int[N + 1];

		int destMap[] = new int[N + 1];

		for (int i = 0; i < trust.length; i++) {
			int row[] = trust[i];

			int src = row[0];
			int dest = row[1];

			srcMap[src]++;
			destMap[dest]++;
		}

		for (int i = 1; i <= N; i++) {
			// All vertex should point to Town Judge Vertex
			// Town Judge Vertex wont be source
			if (destMap[i] == N - 1 && srcMap[i] == 0) {
				return i;
			}
		}
		return -1;
	}
}

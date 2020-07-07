package leetcoce;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPoints {

	public int[][] kClosest(int[][] points, int K) {

		int result[][] = new int[K][2];

		if (points == null || points.length == 0) {
			return result;
		}

		int len = points.length;

		PriorityQueue<Point> maxHeap = new PriorityQueue<>((p, q) -> (q.x * q.x + q.y * q.y) - (p.x * p.x + p.y * p.y));

		// O(NlogK)
		for (int i = 0; i < len; i++) {
			int x = points[i][0];
			int y = points[i][1];

			Point a = new Point(x, y);
			maxHeap.offer(a);

			if (maxHeap.size() > K) {
				maxHeap.poll();
			}
		}

		int i = 0;
		while (!maxHeap.isEmpty()) {
			Point p = maxHeap.poll();
			result[i][0] = p.x;
			result[i][1] = p.y;
			i++;
		}
		return result;
	}

	private class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/*
	 * Time: O(NlogN) - N length of points
	 * Space: O(N) for distance Arrays
	 */
	public int[][] kClosestLeetCode(int[][] points, int K) {
		int N = points.length;
		int[] dists = new int[N];

		for (int i = 0; i < N; ++i) {
			dists[i] = dist(points[i]);
		}

		Arrays.sort(dists);
		int distK = dists[K - 1];

		int[][] ans = new int[K][2];
		int t = 0;
		for (int i = 0; i < N; ++i)
			if (dist(points[i]) <= distK)
				ans[t++] = points[i];
		return ans;
	}

	public int dist(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}

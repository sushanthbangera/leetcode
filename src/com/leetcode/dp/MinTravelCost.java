package com.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class MinTravelCost {

	Integer memo[];
	Set<Integer> tdays;
	int costs[];

	public int mincostTickets(int[] days, int[] costs) {
		this.costs = costs;
		memo = new Integer[366];
		tdays = new HashSet<>();
		for (int d : days)
			tdays.add(d);

		return dp(1);
	}

	private int dp(int i) {

		if (i > 365)
			return 0;

		if (memo[i] != null)
			return memo[i];

		int ans;
		if (tdays.contains(i)) {
			ans = Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]);
			ans = Math.min(ans, dp(i + 30) + costs[2]);
		} else {
			ans = dp(i + 1);
		}

		memo[i] = ans;
		return ans;
	}

	public int mincostTickets2(int[] days, int[] costs) {
		this.costs = costs;
		memo = new Integer[366];
		tdays = new HashSet<>();
		for (int d : days)
			tdays.add(d);

		return recursion(1);
	}

	private int recursion(int i) {

		if (i > 365)
			return 0;

		int ans;
		if (tdays.contains(i)) {
			int dayPassCost = recursion(i + 1) + costs[0];
			int weekPassCost = recursion(i + 7) + costs[1];
			int monthPassCost = recursion(i + 30) + costs[2];

			ans = Math.min(dayPassCost, Math.min(weekPassCost, monthPassCost));

		} else {
			ans = recursion(i + 1);
		}

		return ans;
	}

	public static void main(String[] args) {
		MinTravelCost mtc = new MinTravelCost();
		int costs[] = { 2, 7, 15 };
		int days[] = { 1, 4, 6, 7, 8, 20 };
		System.out.println(mtc.mincostTickets(days, costs));
		System.out.println(mtc.mincostTickets2(days, costs));
	}
}

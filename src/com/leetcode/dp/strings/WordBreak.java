package com.leetcode.dp.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	/*
	 * Using recursion - Time Limit exceeded
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dicts = new HashSet<>();
		for (String str : wordDict) {
			dicts.add(str);
		}
		if (dicts.contains(s))
			return true;
		return dfs(s, dicts);
	}

	private boolean dfs(String s, Set<String> dicts) {

		if (s.equals(""))
			return true;
	
		for (int i = 1; i <= s.length(); i++) {
			if (dicts.contains(s.substring(0, i)) && dfs(s.substring(i, s.length()), dicts)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Memoization
	 */
	public boolean wordBreak2(String s, List<String> wordDict) {

		Set<String> dicts = new HashSet<>();
		for (String str : wordDict) {
			dicts.add(str);
		}
		if (dicts.contains(s))
			return true;

		Map<String, Boolean> map = new HashMap<>();
		return dfs(s, dicts, map);
	}

	private boolean dfs(String s, Set<String> dicts, Map<String, Boolean> map) {

		if (s.equals(""))
			return true;
		if (map.containsKey(s))
			return map.get(s);

		for (int i = 1; i <= s.length(); i++) {
			if (dicts.contains(s.substring(0, i)) && dfs(s.substring(i, s.length()), dicts, map)) {
				map.put(s.substring(i, s.length()), true);
				return true;
			}
		}
		map.put(s, false);
		return false;
	}
	
	public boolean wordBreak3(String s, List<String> wordDict) {

		Set<String> dicts = new HashSet<>();
		for (String str : wordDict) {
			dicts.add(str);
		}
		
		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}

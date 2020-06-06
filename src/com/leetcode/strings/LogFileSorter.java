package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leetcode.utils.ArrayUtils;

/*
 * 937. Reorder Data in Log Files
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class LogFileSorter {

	public String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, (log1, log2) -> {

			String s1[] = log1.split("\\s+", 2);
			String s2[] = log2.split("\\s+", 2);

			boolean isChar1 = Character.isLetter(s1[1].charAt(0));
			boolean isChar2 = Character.isLetter(s2[1].charAt(0));

			if (isChar1 && isChar2) {
				int compareVal = s1[1].compareTo(s2[1]);
				if (compareVal != 0) {
					return compareVal;
				}
				return s1[0].compareTo(s2[0]);
			}
			return !isChar1 ? (!isChar2 ? 0 : 1) : -1;
		});

		return logs;
	}

	public String[] reorderLogFiles2(String[] logs) {

		List<String> letterLogs = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();

		for (String log : logs) {
			if (Character.isDigit(log.split("\\s+")[1].charAt(0))) {
				digitLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}

		Collections.sort(letterLogs, (o1, o2) -> {
			String[] s1 = o1.split("\\s+", 2);
			String[] s2 = o2.split("\\s+", 2);

			if (s1[1].compareTo(s2[1]) == 0) {
				return s1[0].compareTo(s2[0]);
			}
			return s1[1].compareTo(s2[1]);
		});

		String[] ans = new String[logs.length];
		
		int i = 0;
		for (String log : letterLogs) {
			ans[i++] = log;
		}

		for (String log : digitLogs) {
			ans[i++] = log;
		}

		return ans;
	}

	public static void main(String[] args) {
		String logs[] = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		ArrayUtils.print(logs);

		System.out.println("---------------------");

		LogFileSorter logFileSorter = new LogFileSorter();

		String[] sortedLogs = logFileSorter.reorderLogFiles(logs);
		ArrayUtils.print(sortedLogs);

		System.out.println("---------------------");

		String logs2[] = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };

		sortedLogs = logFileSorter.reorderLogFiles2(logs2);
		ArrayUtils.print(sortedLogs);

	}
}

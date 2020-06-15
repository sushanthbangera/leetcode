package com.leetcode.arrays;

import java.util.Arrays;

public class AttendMeetings {

	class Interval {

		int startTime;

		int endTime;

		Interval(int start, int end) {
			this.startTime = start;
			this.endTime = end;
		}

	}

	public boolean canAttendMeetings(Interval[] intervals) {

		Arrays.sort(intervals, (a, b) -> a.startTime - b.startTime);

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].endTime > intervals[i + 1].startTime) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		AttendMeetings m = new AttendMeetings();
		Interval a = m.new Interval(0, 5);
		Interval b = m.new Interval(5, 10);
		Interval c = m.new Interval(15, 20);

		Interval[] intervals = { a, b, c };

		System.out.println(m.canAttendMeetings(intervals) ? "Can attend all meetings" : "Cannot attend all meetings");
	}
}

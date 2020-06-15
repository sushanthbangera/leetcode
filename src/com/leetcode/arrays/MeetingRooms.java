package com.leetcode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] 
 * find the minimum number of conference rooms required.
 */

public class MeetingRooms {

	class Interval {

		int startTime;

		int endTime;

		Interval(int start, int end) {
			this.startTime = start;
			this.endTime = end;
		}

	}

	public int minMeetingRooms(Interval[] intervals) {

		Arrays.sort(intervals, (a, b) -> a.startTime - b.startTime);

		PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
		minHeap.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			
			Interval current = intervals[i];
			Interval existing = minHeap.remove();
			// if the current meeting is after the existing one
			if (current.startTime >= existing.endTime) {
				existing.endTime = current.endTime;
			} else {
				minHeap.add(current);
			}
			minHeap.add(existing);
		}
		return minHeap.size();
	}

	public static void main(String[] args) {
		
		MeetingRooms m = new MeetingRooms();
		Interval a = m.new Interval(0, 30);
		Interval b = m.new Interval(5, 10);
		Interval c = m.new Interval(15, 20);

		Interval[] intervals = { a, b, c };

		System.out.println("No of meeting rooms: " + m.minMeetingRooms(intervals));
	}
}

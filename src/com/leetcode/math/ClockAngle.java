package com.leetcode.math;

/*
 * 1344. Angle Between Hands of a Clock
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */
public class ClockAngle {

	public double angleClock(int hour, int minutes) {

		int oneHourAngle = 30;
		double oneMinuteAngle = 0.5;

		double angleByMinutesHand = minutes * 6;
		double angleByHoursHand = (hour % 12) * oneHourAngle + oneMinuteAngle * minutes;

		double angle = Math.abs(angleByMinutesHand - angleByHoursHand);

		return angle > 180 ? 360 - angle : angle;
	}
}

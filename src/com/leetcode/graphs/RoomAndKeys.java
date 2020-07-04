package com.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class RoomAndKeys {

	/*
	 * Time: O(V + E) - V rooms and E keys
	 * Space: O(n) - queue a
	 */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Set<Integer> keys = new HashSet<>(); // to store the unique keys
		keys.add(0);

		Queue<Integer> q = new ArrayDeque<>(); // to visit rooms as per the keys obtained
		q.add(0);

		while (!q.isEmpty()) {

			int roomId = q.poll();

			List<Integer> roomKeys = rooms.get(roomId);

			for (int key : roomKeys) {
				if (keys.add(key)) { // if key is already in the set its already added to queue
					q.add(key);
				}
			}
		}
		// if no of keys is equal to number of rooms return true;
		return keys.size() == rooms.size();
	}

	/*
	 * Solution from leetcode
	 */
	public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
		boolean[] seen = new boolean[rooms.size()];
		seen[0] = true;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		// At the beginning, we have a todo list "stack" of keys to use.
		// 'seen' represents at some point we have entered this room.
		while (!stack.isEmpty()) { // While we have keys...
			int node = stack.pop(); // Get the next key 'node'
			for (int nei : rooms.get(node)) // For every key in room # 'node'...
				if (!seen[nei]) { // ...that hasn't been used yet
					seen[nei] = true; // mark that we've entered the room
					stack.push(nei); // add the key to the todo list
				}
		}

		for (boolean v : seen) // if any room hasn't been visited, return false
			if (!v) {
				return false;
			}
		return true;
	}
}

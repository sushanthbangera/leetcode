package com.leetcode.design;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/*
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
	private static Map<Integer, Integer> map;

	private static Deque<Integer> dq;

	private static int cacheSize;

	public LRUCache(int capacity) {
		cacheSize = capacity;
		map = new HashMap<>(cacheSize);
		dq = new LinkedList<>();
	}

	public int get(int key) {
        if (map.containsKey(key)) {
            dq.remove(key); // removing the element from cache
            dq.push(key); // insert it from the top
            return map.get(key);
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if (dq.size() == cacheSize) {
                int lastElement = dq.removeLast();
                map.remove(lastElement);
            }
        } else {
            dq.remove(key);
        }
        map.put(key, value);
        dq.push(key);
    }

	public void display() {
		Iterator<Integer> it = dq.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.display();

		cache.get(1); // returns 1
		cache.display();
		cache.put(3, 3); // evicts key 2
		cache.display();
		cache.get(2); // returns -1 (not found)
		cache.display();
		cache.put(4, 4); // evicts key 1
		cache.display();
		cache.get(1); // returns -1 (not found)
		cache.display();
		cache.get(3); // returns 3
		cache.display();
		cache.get(4); // returns 4
		cache.display();
	}
}
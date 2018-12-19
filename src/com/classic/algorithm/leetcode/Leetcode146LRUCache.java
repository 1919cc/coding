package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 *
 */

public class Leetcode146LRUCache {
	public static void main(String[] args) {

	}

	    class Node {
	        int key;
	        int value;

	        Node next;
	        Node pre;

	        Node(int k, int val) {
	            key = k;
	            value = val;
	        }
	    }

	    Map<Integer, Node> map = new HashMap<>();

	    int maxSize;
	    int curSize;

	    Node head; // most recent used
	    Node tail; // least recent used

	    public Leetcode146LRUCache(int capacity) {
	        maxSize = capacity;
	        curSize = 0;
	    }

	    public int get(int key) {
	        if (map.containsKey(key)) {
	            moveNodeToHead(map.get(key));

	            return head.value;
	        }

	        return -1;
	    }

	    public void put(int key, int value) {
	        if (map.containsKey(key)) {
	            Node n = map.get(key);
	            n.value = value;

	            moveNodeToHead(n);
	        } else {
	            if (curSize < maxSize) {
	                if (head == null) {
	                    head = new Node(key, value);
	                    head.next = head.pre = null;
	                    tail = head;
	                } else {
	                    head.next = new Node(key, value);
	                    head.next.pre = head;
	                    head = head.next;
	                    head.next = null;
	                }

	                curSize++;
	                System.out.println("Hello 1 put" + head);
	                map.put(key, head);
	            } else {
	                map.remove(tail.key);
	                tail = tail.next;
	                tail.pre.next = null;
	                tail.pre = null;

	                head.next = new Node(key, value);
	                head.next.pre = head;
	                head = head.next;
	                head.next = null;
	                System.out.println("Hello 2 put" + head);
	                map.put(key, head);
	            }
	        }
	    }

	    public void moveNodeToHead(Node n) {
	        if (n != head) {
	            if (n == tail) {
	                tail = tail.next;
	                tail.pre = null;
	            } else {
	                n.pre.next = n.next;
	                n.next.pre = n.pre;
	            }

	            head.next = n;
	            n.pre = head;

	            head = n;
	            n.next = null;
	        }
	    }
	}


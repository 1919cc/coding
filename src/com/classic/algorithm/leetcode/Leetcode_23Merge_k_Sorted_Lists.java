package com.classic.algorithm.leetcode;

import java.util.PriorityQueue;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

public class Leetcode_23Merge_k_Sorted_Lists {
//	 * Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	     ListNode(int x) { val = x; }
	 }

	  // recursion
    public ListNode mergeKLists(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                count++;
                continue;
            }
            if (min >= lists[i].val) {
                min = lists[i].val;
                index = i;
            }
        }

        if (count == lists.length) return null;

        ListNode res = lists[index];

        if (lists[index] != null)  lists[index] = lists[index].next;

        if (res != null) {
            res.next = mergeKLists(lists);
        }

        return res;
    }

    // by using priority queue
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((n1, n2)->(n1.val - n2.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode run = head;

        while (!queue.isEmpty()) {
            run.next = queue.poll();

            if (run.next != null && run.next.next != null) queue.offer(run.next.next);
            run = run.next;
        }

        return head.next;
    }
}

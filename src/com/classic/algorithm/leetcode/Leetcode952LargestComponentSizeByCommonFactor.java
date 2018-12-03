package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 *

Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

Example 1:

Input: [4,6,15,35]
Output: 4

Example 2:

Input: [20,50,9,63]
Output: 2

Example 3:

Input: [2,3,6,7,4,12,21,39]
Output: 8

Note:

1 <= A.length <= 20000
1 <= A[i] <= 100000
 */

public class Leetcode952LargestComponentSizeByCommonFactor {
	// Time limited exceeded solution

    public int largestComponentSize(int[] A) {
        Map<Integer, List<Integer>> G = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                // System.out.println(A[i] + " " + A[j]);
                if (i != j && shareDivisor(A[i], A[j])) {
                    G.putIfAbsent(A[i], new LinkedList<Integer>());
                    G.get(A[i]).add(A[j]);
                }
            }
        }
        // System.out.println("xxxxx 7 , 21 " + shareDivisor(7, 21));
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length && !G.isEmpty(); i++) {
            if (!G.containsKey(A[i])) continue;

            q.add(A[i]);
            while (!q.isEmpty()) {
                Integer k = q.poll();
                set.add(k);
                if (!G.containsKey(k)) continue;
                List<Integer> list = G.get(k);
                G.remove(k);
                for (Integer num : list) {
                    set.add(num);
                    q.add(num);
                }
            }
            // System.out.println(count);
            count = Math.max(count, set.size());
            // Iterator x =  set.iterator();
            // while (x.hasNext()) System.out.print(x.next() + " ");
            set.clear();
        }
        return count;
    }

    public boolean shareDivisor(int a, int b) {
        if (a > b) {
            while (a%b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            return b >= 2;
        } else return shareDivisor(b, a);
    }
}

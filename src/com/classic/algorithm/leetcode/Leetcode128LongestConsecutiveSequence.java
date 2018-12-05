package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 *
 *Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

public class Leetcode128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        int max = 0;

        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int left = (map.containsKey(n-1)) ? map.get(n-1) : 0;
            int right = (map.containsKey(n+1)) ? map.get(n+1) : 0;

            int sum = left + right + 1;

            map.put(n, sum);

            map.put(n-left, sum);
            map.put(n+right, sum);

            max = Math.max(max, sum);
        }

        return max;
    }
}

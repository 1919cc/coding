package com.classic.algorithm.leetcode;

import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 *
 */

public class Leetcode239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0) return nums;
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            if (!list.isEmpty() && list.peek() == i-k) list.poll();
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) list.removeLast();
            list.offerLast(i);
            if (i >= k-1) res[i-k+1] = nums[list.peek()];
        }
        return res;
    }
}

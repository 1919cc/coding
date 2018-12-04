package com.classic.algorithm.leetcode;

import java.util.Stack;

/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */

public class Leetcode_84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || stack.peek() <= heights[i]) {
                stack.push(heights[i]);
            } else {
                int count = 0;
                while (!stack.empty() && stack.peek() > heights[i]) {
                    res = Math.max(res, stack.pop() * ++count);
                }

                while (count-- >= 0) stack.push(heights[i]);
            }
        }

        int count = 0;
        while (!stack.isEmpty()) {
            res = Math.max(res, stack.pop()*++count);
        }

        return res;
    }
}

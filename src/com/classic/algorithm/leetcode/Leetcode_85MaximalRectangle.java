package com.classic.algorithm.leetcode;

import java.util.Stack;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */

public class Leetcode_85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack();

        int[] H = new int[matrix[0].length];

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[j][i] == '1') H[i]++;
                else H[i] = 0;

                if (stack.isEmpty() || stack.peek() <= H[i]) stack.push(H[i]);
                else {
                    int count = 0;
                    while (!stack.isEmpty() && stack.peek() > H[i]) {
                        res = Math.max(res, stack.pop() * ++count);
                    }

                    while (count-- >= 0) stack.push(H[i]);
                }
            }

            int count = 0;
            while (!stack.isEmpty()) res = Math.max(res, stack.pop()* ++count);
        }

        return res;
    }
}
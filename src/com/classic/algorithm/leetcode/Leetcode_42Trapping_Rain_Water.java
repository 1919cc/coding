package com.classic.algorithm.leetcode;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */

public class Leetcode_42Trapping_Rain_Water {
    public int trap(int[] height) {
        int area = 0;
        int left = 0, right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (maxLeft < height[left]) maxLeft = height[left];
                area += maxLeft - height[left++];
            } else {
                if (maxRight < height[right]) maxRight = height[right];
                area += maxRight - height[right--];
            }
        }
        return area;
    }
}
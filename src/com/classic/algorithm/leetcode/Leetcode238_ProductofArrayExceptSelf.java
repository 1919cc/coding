package com.classic.algorithm.leetcode;

import java.util.Arrays;

public class Leetcode238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1]; // left side value
        }
        int right = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            right *=  nums[i+1];
            res[i] *= right;
        }
        return res;
    }
}
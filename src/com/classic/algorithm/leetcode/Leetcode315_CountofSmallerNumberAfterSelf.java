package com.classic.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode315_CountofSmallerNumberAfterSelf {
	// TLE, O(N^2)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i+1; j< nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
            res.add(count);
        }
        return res;
    }
}
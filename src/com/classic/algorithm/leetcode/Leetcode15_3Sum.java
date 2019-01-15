package com.classic.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i-1] == nums[i]) continue; // skip the dup
            
            for (int j = i+1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue; // skip the dup
                if (-nums[i]-nums[j] < nums[j]) break;
                int sum = nums[i] + nums[j];
                if (map.containsKey(-sum)) {
                    int index = map.get(-sum);
                    if (index > j)
                        res.add(new LinkedList(Arrays.asList(nums[i], nums[j], nums[index])));
                }
            }
        }
        
        return res;
    }
}
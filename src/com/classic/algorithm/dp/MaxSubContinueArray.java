package com.classic.algorithm.dp;

public class MaxSubContinueArray {
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int tempMax = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			tempMax = Math.max(nums[1], tempMax + nums[1]);
			max = Math.max(max, tempMax);
		}
		
		return max;
	}
}

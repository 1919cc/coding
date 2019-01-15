package com.classic.algorithm.leetcode;

public class Leetcode_215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int m = n-k;
        
        int left = 0;
        int right = n-1;
        
        while (left <= right) {
            int index = partition(nums, left, right);
            
            if (index == m) return nums[m];
            else if (index < m) left = index+1;
            else if (index > m) right = index-1;
        }
        return -1;
    }
    
    public int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) right--;
            if (left < right) nums[left] = nums[right];
            while (left < right && nums[left] <= temp) left++;
            if (left < right) nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}
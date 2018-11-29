package com.classic.algorithm.leetcode;

/*
 *
	There are two sorted arrays nums1 and nums2 of size m and n respectively.

	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

	You may assume nums1 and nums2 cannot be both empty.

	Example 1:

	nums1 = [1, 3]
	nums2 = [2]

	The median is 2.0
	Example 2:

	nums1 = [1, 2]
	nums2 = [3, 4]

	The median is (2 + 3)/2 = 2.5

 */

// use the partition function, remove the k/2 element everytime
// O(log(N+M))

public class Leetcode4_Median_Of_Two_Sorted_Array4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length + nums2.length;
        int k = m/2;

        if (m%2 != 0 )
            return findK(nums1, 0, nums1.length, nums2, 0, nums2.length, k+1);
        else return (findK(nums1, 0, nums1.length, nums2, 0, nums2.length, k)
            + findK(nums1, 0, nums1.length, nums2, 0, nums2.length, k+1))/2;
    }

    public double findK(int[] a, int sa, int lenA, int[] b, int sb, int lenB, int k) {
        if (lenA > lenB) return findK(b, sb, lenB, a, sa, lenA, k);
        if (lenA == 0) return b[sb + k-1];
        if (k == 1) return Math.min(a[sa], b[sb]);

        int p = Math.min(k/2, lenA);
        int q = k - p;

        if (a[sa + p-1] < b[sb + q-1]) return findK(a, sa+p, lenA-p,b, sb, lenB, k-p);
        else if (a[sa+p-1] > b[sb + q-1]) return findK(a, sa, lenA, b, sb+q, lenB-q, k-q);
        return a[sa+p-1];
    }
}

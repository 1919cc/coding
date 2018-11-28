package com.classic.algorithm.leetcode;

public class findK_partition {
	public int findK(int[] arr, int left, int right, int k) {
		int pos = partition(arr, left, right);

		if (pos == k-1) return arr[k-1];
		else if (pos < k-1) {
			return findK(arr, pos+1, right, k);
		} else {
			return findK(arr, left, pos-1, k);
		}
	}

	public int partition(int[] arr, int m, int n) {
		int temp = arr[m];

		while (m < n) {
			while (m < n && temp <= arr[n]) n--;
			if (m < n) arr[m] = arr[n];

			while (m < n && temp >= arr[m]) m++;
			if (m < n) arr[n] = arr[m];
		}

		arr[m] = temp;

		return m;
	}
}
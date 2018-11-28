package com.classic.algorithm.sort;

public class Exchange_QuickSort {
	public static int partition(int[] arr, int left, int right) {
		int temp = arr[left];

		while (left < right) {
			while (left < right && arr[right] >= temp) right--;

			if (left < right) arr[left] = arr[right];

			while (left < right && arr[left] <= temp) left++;

			if (left < right) arr[right] = arr[left];
		}

		System.out.println("left = " + left + "  right = " + right + "  temp = " + temp);
		arr[left] = temp;

		return left;
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int dp = partition(arr, left, right);

			quickSort(arr, left, dp-1);
			quickSort(arr, dp+1, right);
		}
	}
}

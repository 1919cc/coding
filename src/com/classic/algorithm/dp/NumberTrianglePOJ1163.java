package com.classic.algorithm.dp;

public class NumberTrianglePOJ1163 {
	public int getShortestLength(int[][] matrix, int n) {
		int[] MaxSum = matrix[n-1];
		
		for (int i = n-2; i >= 0; i--)
			for (int j = 0; j <= i; j++)
				MaxSum[i] = Math.max(MaxSum[j], MaxSum[j+1]) + matrix[i][j];
		
		return MaxSum[0];
	}
}

package com.classic.algorithm.dp;

public class KnapsackProblem {
	public int knapsack(int[] value, int[] weight, int capacity) {
		int[][] V = new int[value.length+1][capacity+1];
		
		for (int i = 1; i <= value.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (j < weight[j-1]) V[i][j] = V[i-1][j];
				else V[i][j] = Math.max(V[i-1][j], V[i-1][j-weight[j-1]] + value[i-1]);
			}
		}
		
		return V[value.length][capacity];
	}
	
	public int knapsack2(int[] value, int[] weight, int capacity) {
		int[] B = new int[capacity+1];
		
		for (int i = 1; i < value.length; i++)
			for (int j = capacity; j >= 0; j--)
				if (j >= weight[i]) B[j] = Math.max(B[j], B[j-weight[i]] + value[i]);
		
		return B[capacity];
	}
}
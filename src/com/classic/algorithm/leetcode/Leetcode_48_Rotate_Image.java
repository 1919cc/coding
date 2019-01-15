package com.classic.algorithm.leetcode;

public class Leetcode_48_Rotate_Image {
	
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // diagonal rotate from left to right
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-1-i; j++) swap(matrix, i, j, n-1-j, n-1-i);
        // horizontal rotate from up to down
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n; j++) swap(matrix, i, j, n-1-i, j);
    }
    
    public void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}
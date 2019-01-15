package com.classic.algorithm.leetcode;

public class Leetcode_73_Set_Matrix_Zeros {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][0] == 0) firstColZero = true;
        
        for (int j = 0; j < matrix[0].length; j++)
            if (matrix[0][j] == 0) firstRowZero = true;
        
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) matrix[0][j] = matrix[i][0] = 0;
        
        for (int i = 1; i < matrix.length; i++)
            if (matrix[i][0] == 0)
                for (int j = 1; j < matrix[0].length; j++) matrix[i][j] = 0;
        
        for (int j = 1; j < matrix[0].length; j++)
            if (matrix[0][j] == 0)
                for (int i = 1; i < matrix.length; i++) matrix[i][j] = 0;
        
        if (firstColZero)
            for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        
        if (firstRowZero)
            for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;

    }
    
    // another genious solution from:
    // https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
    public void setZeroes2(int[][] matrix) {
        int col0 = 1, row = matrix.length, col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < col; j++)
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
        }
        
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j > 0; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
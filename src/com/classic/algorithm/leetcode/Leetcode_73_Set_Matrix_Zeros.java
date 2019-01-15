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
}
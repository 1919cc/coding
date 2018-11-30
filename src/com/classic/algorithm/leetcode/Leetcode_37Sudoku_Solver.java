package com.classic.algorithm.leetcode;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */


// recursion, back trace
public class Leetcode_37Sudoku_Solver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(b, i, j, c)) {
                            b[i][j] = c;

                            if (solve(b)) return true;
                            else b[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] b, int i, int j, char c) {
        int x = (i / 3) * 3;
        int y = (j / 3) * 3;

        for (int m = 0; m < 9; m++) {
            if (b[i][m] == c || b[m][j] == c
                    || b[x + m/3][y + m%3] == c) return false;

        }
        return true;
    }
}

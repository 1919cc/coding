package com.classic.algorithm.leetcode;

import java.util.Arrays;

public class Leetcode976LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        
        int a = 0;
        int b = A[A.length-1];
        int c = A[A.length-2];
        
        for (int i = A.length-3; i >= 0; i--) {
            a = b;
            b = c;
            c = A[i];
            
            if (a+b > c && a+c > b && b+c > a) return a+b+c;
        }
        
        return 0;
    }
}

package com.classic.algorithm.dp;

// every time only climb one stair or two stair, how many stair for N
public class ClimbStair {
	public static void main(String[] args) {
		System.out.println(climbStair(3));
	}
	public static int climbStair(int N) {
		if (N < 0) return 0;
		if (N <= 2) return N;
		
		int a = 1;
		int b = 2;
		int c = 0;
		
		for (int i = 3; i <= N; i++) {
			c = a + b;
			a = b;
			b = c;			
		}
		
		return c;
	}
}
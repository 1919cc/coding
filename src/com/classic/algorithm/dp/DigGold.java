package com.classic.algorithm.dp;

// W workforce dig for N gold mine
public class DigGold {
	public static int getMostGold(int[] gold, int[] people, int w) {
		int[] res = new int[people.length];
		
		for (int i = 0; i < gold.length; i++) {
			if (i >= people[i]) res[i] = gold[i];
			else res[i] = 0;
		}
		
		for (int i = 0; i < gold.length; i++) {
			for (int j = 0; j <= w; j++) {
				if (j >= people[j]) res[j] = Math.max(res[j], res[j-people[i]] + gold[i]);
			}
		}
		
		return gold[gold.length-1];
	}
}
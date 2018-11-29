package com.classic.algorithm.leetcode;

/*
 * 10. Regular Expression Matching
Hard
1912
398


Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */


public class Leetcode10_Regular_Expression_Matching {
	// recursion
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) return s.isEmpty();

		if (p.length() == 1) {
			return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		}

		if (p.charAt(2) != '*') {
			if (s.isEmpty()) return false;
			return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
		}

		while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) return true;
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));
	}

	// dynamic programming
	public boolean isMatchDp(String s, String p) {
		int m = s.length();
		int n = p.length();

		boolean[][] P = new boolean[m+1][n+1];
		P[0][0] = true;

		for (int i = 0; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j-1)== '*')
					P[i][j] = P[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && P[i-1][j]);
				else P[i][j] = i > 0 && P[i-1][j-1] && P[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
			}
		}

		return P[m][n];
	}
}

// space O(M*N), time O(M*N)

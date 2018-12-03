package com.classic.algorithm.leetcode;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Leetcode_76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int cc = t.length();
        int[] ch = new int[128];

        for (char c: t.toCharArray()) ch[c]++;

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;

        while (i < s.length()) {
            if (ch[s.charAt(i++)]-- > 0) cc--;

            while (cc == 0) {
                if (i - j < min) min = i - (start = j);
                if (ch[s.charAt(j++)]++ == 0) cc++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start+min);
    }
}
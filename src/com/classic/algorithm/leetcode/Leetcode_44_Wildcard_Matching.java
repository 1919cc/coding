package com.classic.algorithm.leetcode;

public class Leetcode_44_Wildcard_Matching {

	// recursion -- but time out
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        if (p.charAt(0) != '*') {
            if (s.isEmpty()) return false;
            else return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?') && isMatch(s.substring(1), p.substring(1));
        }

        if (s.isEmpty()) {
            return isMatch(s, p.substring(1));
        } else {
            return isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(1)) || isMatch(s, p.substring(1));
        }
    }

    // dp solution with 2D table
    public boolean isMatch2(String s, String p) {
    	boolean[][] match = new boolean[s.length()+1][p.length()+1];
    	match[s.length()][p.length()] = true;

    	for (int i = p.length()-1; i >= 0; i--) {
    		if (p.charAt(i) != '*') break;
    		else match[s.length()][i] = true;
    	}

    	for (int i = s.length()-1; i >= 0; i--) {
    		for (int j = p.length()-1; j >= 0; j--) {
    			if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
    				match[i][j] = match[i+1][j+1];
    			} else if (p.charAt(j) == '*')
    				match[i][j] = match[i+1][j] || match[i][j+1];
    			else match[i][j] = false;
    		}
    	}
    	return match[0][0];
    }
}

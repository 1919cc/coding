package com.classic.algorithm.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_139_Word_Break {
    // Time O(N^2), Space O(N)
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    
    public boolean helper(String s, Set<String> wordDict, int start, Boolean[] visited) {
        if (start == s.length()) return true;
        
        if (visited[start] != null) return visited[start];
        System.out.print(start+", ");
        for (int end = start+1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))
                    && helper(s, wordDict, end, visited))
                return visited[start] = true;
        }
        
        return visited[start]=false;
    }
    
    // https://leetcode.com/problems/word-break/solution/
    // approach 4
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    // Time O(N^2), Space O(N)
}
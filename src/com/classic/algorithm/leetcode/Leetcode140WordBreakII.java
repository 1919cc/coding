package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leetcode140WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return permutation(wordDict, new HashMap<String, List<String>>(), s);
    }
    
    public List<String> permutation(List<String> wordDict, HashMap<String, List<String>> map, String s) {
        if (map.containsKey(s)) return map.get(s);
        
        List<String> res = new LinkedList<>();
        
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        
        for (String w : wordDict) {
            if (s.startsWith(w)) {
                List<String> subList = permutation(wordDict, map, s.substring(w.length()));
                for (String ss : subList)
                    res.add(w + (ss.isEmpty() ? "" : " ") + ss);
            }
        }
        
        map.put(s, res);
        return res;
    }
}
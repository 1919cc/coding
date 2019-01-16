package com.classic.algorithm.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_127_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> curLayer = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        
        curLayer.add(beginWord);
        int len = 1;
        while (!curLayer.isEmpty()) {
            len++;
            Set<String> nextLayer = new HashSet<>();
            for (String ss : curLayer) {
                for (String sdict : dict) {
                    if (isConnect(ss, sdict)) {
                        if (endWord.equals(sdict)) return len;
                        nextLayer.add(sdict);
                    }
                }
            }
            dict.removeAll(nextLayer);
            dict.removeAll(curLayer);
            curLayer = nextLayer;
        }
        
        return 0;
    }
    
    public boolean isConnect(String b, String e) {
        int diffLen = 0;
        for (int i = 0; i < e.length(); i++) {
            if (b.charAt(i) != e.charAt(i)) diffLen++;
            if (diffLen > 1) return false;
        }
        return true;
    }
}
package com.classic.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        
        List<Integer> res = new LinkedList<>();
        
        int start = -1, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, map[S.charAt(i) - 'a']);
            
            if (i == end) {
                res.add(end - start);
                start = end;
            }
        }
        
        return res;
    }
}
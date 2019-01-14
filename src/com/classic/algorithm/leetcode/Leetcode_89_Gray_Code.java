package com.classic.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_89_Gray_Code {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        
        int total = 1<<n;
        
        for (int i = 0; i < total; i++) {
            res.add((i >> 1)^i);
        }
        
        return res;
    }
}
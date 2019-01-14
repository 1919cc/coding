package com.classic.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode771_Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (set.contains(ch)) cnt++;
        }
        return cnt;
    }
    
    public int numJewelsInStones2(String J, String S) {
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) > -1) cnt++;
        }
        return cnt;
    }
}

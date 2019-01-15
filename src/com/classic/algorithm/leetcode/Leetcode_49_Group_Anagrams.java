package com.classic.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode_49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String ss : strs) {
            char[] ssArray = ss.toCharArray();
            Arrays.sort(ssArray);
            String key = new String(ssArray);
            
            if (!map.containsKey(key)) {
                List<String> res = new LinkedList<>();
                res.add(ss);
                map.put(key, res);
            } else {
                List<String> res = (List<String>)map.get(key);
                res.add(ss);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (Map.Entry en : map.entrySet()) result.add((List<String>)en.getValue());
        return result;
    }
    
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String ss : strs) {
            char[] ssArray = ss.toCharArray();
            Arrays.sort(ssArray);
            String key = new String(ssArray);
            
            if (!map.containsKey(key)) map.put(key, new LinkedList());
            map.get(key).add(ss);
        }
        return new LinkedList(map.values());
    }
    
    // for sort string, could be reduced to K, so the NK, above is NklogK
}
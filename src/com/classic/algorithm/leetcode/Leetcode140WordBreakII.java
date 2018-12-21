package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
public class Leetcode140WordBreakII {
	// permutation, TLE
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);

        List<String> result = new LinkedList();
        String cur = "";

        permutation(words, s, 0, result, cur);

        return result;
    }

    public void permutation(Set<String> words, String s, int start, List<String> result, String cur) {
        int len = s.length();
        if (start >= len) return;

        for (int i = start+1; i <= len; i++) {
            String w = s.substring(start, i);
            if (!words.contains(w)) continue;
            if (i == len) result.add((cur == null || cur.length() == 0) ? w : cur + " "+ w);
            else{
                permutation(words, s, i, result, (cur == null || cur.length() == 0) ? w : cur + " "+ w);
            }
        }
    }


    // another method
    public List<String> wordBreak2(String s, List<String> wordDict) {
        return permutation2(wordDict, new HashMap<String, List<String>>(), s);
    }

    public List<String> permutation2(List<String> wordDict, HashMap<String, List<String>> map, String s) {
        if (map.containsKey(s)) return map.get(s);

        List<String> res = new LinkedList<>();

        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String w : wordDict) {
            if (s.startsWith(w)) {
                List<String> subList = permutation2(wordDict, map, s.substring(w.length()));
                for (String ss : subList)
                    res.add(w + (ss.isEmpty() ? "" : " ") + ss);
            }
        }

        map.put(s, res);
        return res;
    }
}

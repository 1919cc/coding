package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class Leetcode126WordLadderII {
	// AC, by create a directed graph
    public List<List<String>> findLadders3(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList();
        if (wordList == null || wordList.size() == 0) return result;

        Set<String> words = new HashSet(wordList);
        if (!words.contains(endWord)) return result;

        Map<String, List<String>> graph = new HashMap();
        Set<String> curLevel = new HashSet<>();
        curLevel.add(beginWord);

        boolean isFound = false;

        while(!curLevel.isEmpty() && !isFound) {
            words.removeAll(curLevel);  // key to avoid TLE
            Set<String> nextLevel = new HashSet();
            for (String s : curLevel) {
                char[] cur = s.toCharArray();
                graph.put(s, new LinkedList<String>());
                for (int i = 0; i < cur.length; i++) {
                    char c = cur[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (c == ch) continue;
                        cur[i] = ch;
                        String curStr = new String(cur);
                        // System.out.println(curStr);
                        if (words.contains(curStr)) {
                            graph.get(s).add(curStr);
                            nextLevel.add(curStr);
                            if (curStr.equals(endWord)) isFound = true;
                        }
                    }
                    cur[i] = c;
                }
            }
            curLevel = nextLevel;
        }
        if (!isFound) return result;

        LinkedList<String> list = new LinkedList();
        DFS(graph, result, list, beginWord, endWord);

        return result;
    }

    public void DFS(Map<String, List<String>> graph, List<List<String>> result, LinkedList<String> list, String begin, String end) {
        if (begin.equals(end)) {
            result.add(list);
            return;
        }

        if (!graph.containsKey(begin)) return;

        for (String s : graph.get(begin)) {
            list.add(s);
            DFS(graph, result, new LinkedList<String>(list), s, end);
            list.removeLast();
        }
    }

    public void DFS2(Map<String, List<String>> graph, List<List<String>> result, LinkedList<String> list, String begin, String end) {
        if (!graph.containsKey(begin)) return;
        list.add(begin);

        for (String s : graph.get(begin)) {
            if (s.equals(end)) {
                list.add(s);
                result.add(list);
            } else {
            	DFS2(graph, result, new LinkedList<String>(list), s, end);
            }
        }
    }

	// Time Limited exceed
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, LinkedList<String>> map = new HashMap();
        map.putIfAbsent(beginWord, new LinkedList<String>());

        List<List<String>> allRes = new LinkedList<List<String>>();

        int size = wordList.size();

        for (int i = 0; i < size; i++) {
            if (isConnected(beginWord, wordList.get(i))) {

                map.get(beginWord).add(wordList.get(i));
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (!wordList.get(i).equals(beginWord) && !wordList.get(j).equals(beginWord) && isConnected(wordList.get(i), wordList.get(j))) {
                    map.putIfAbsent(wordList.get(i), new LinkedList<String>());
                    map.get(wordList.get(i)).add(wordList.get(j));

                    map.putIfAbsent(wordList.get(j), new LinkedList<String>());
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        List<String> res = new LinkedList<String>();
        DFS(allRes, res, map, beginWord, endWord, size);

        int shortLen = Integer.MAX_VALUE;

        for (List<String> list : allRes) shortLen = Math.min(shortLen, list.size());

        List<List<String>> result = new LinkedList<List<String>>();

        for (List<String> list : allRes) {
            if (list.size() == shortLen) result.add(list);
        }

        return result;
    }

    public void DFS(List<List<String>> allRes, List<String> res, Map<String, LinkedList<String>> map, String begin, String end, int depth) {
        if (depth >= 0 && map.containsKey(begin)) {
            List<String> list = map.get(begin);
            for (String s : list) {
                List<String> ress = new LinkedList<>(res);
                ress.add(begin);
                if (s.equals(end)) {
                    ress.add(s);
                    allRes.add(ress);
                } else {
                	DFS(allRes, ress, map, s, end, depth-1);
                }
            }
        }
    }

    public boolean isConnected(String a, String b) {
        if (a.length() != b.length()) return false;

        int len = a.length();
        int count = 0;
        for (int i = 0; i < len; i++)
            if (a.charAt(i) != b.charAt(i)) count++;

        return count == 1;
    }

    // Time Limited exceed
    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        Map<Integer, LinkedList<Integer>> map = new HashMap();

        // beginWord -> -1
        gbegin = beginWord;
        gwordList = wordList;
        int end = -1;

        map.putIfAbsent(-1, new LinkedList<Integer>());

        int size = wordList.size();

        for (int i = 0; i < size; i++) {
            if (isConnected(beginWord, wordList.get(i))) {
                map.get(-1).add(i);
            }
            if (endWord.equals(wordList.get(i))) end = i;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (!wordList.get(i).equals(beginWord) && !wordList.get(j).equals(beginWord) && isConnected(wordList.get(i), wordList.get(j))) {
                    map.putIfAbsent(i, new LinkedList<Integer>());
                    map.get(i).add(j);

                    map.putIfAbsent(j, new LinkedList<Integer>());
                    map.get(j).add(i);
                }
            }
        }

        List<List<String>> allRes = new LinkedList<List<String>>();
        List<String> res = new LinkedList<String>();

        DFS(allRes, res, map, -1, end, size);

        int shortLen = Integer.MAX_VALUE;

        for (List<String> list : allRes) shortLen = Math.min(shortLen, list.size());

        List<List<String>> result = new LinkedList<List<String>>();

        for (List<String> list : allRes) {
            if (list.size() == shortLen) result.add(list);
        }

        return result;
    }
    String gbegin = null;
    List<String> gwordList;

    public void DFS(List<List<String>> allRes, List<String> res, Map<Integer, LinkedList<Integer>> map, int begin, int end, int depth) {
        if (depth >= 0 && map.containsKey(begin)) {
            List<Integer> list = map.get(begin);
            for (Integer s : list) {
                List<String> ress = new LinkedList<>(res);
                if (begin == -1) ress.add(gbegin);
                else ress.add(gwordList.get(begin));

                if (s == end) {
                    ress.add(gwordList.get(s));
                    allRes.add(ress);
                } else {
                	DFS(allRes, ress, map, s, end, depth-1);
                }
            }
        }
    }
}

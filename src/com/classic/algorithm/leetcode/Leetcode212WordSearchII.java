package com.classic.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.
 *
 */

public class Leetcode212WordSearchII {
    // build a TrieTree
    class Tire {
        Tire[] next = new Tire[26];
        String word;
    }
        
    public Tire buildTrie(String[] words) {
        Tire root = new Tire();
        for (String s : words) {
            Tire p = root;
            
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)p.next[i] = new Tire();
                p = p.next[i];
            }
            p.word = s;
        }
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Tire root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, root, i, j, res);
        return res;
    }
    
    public void dfs(char[][] board, Tire p, int i, int j, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c-'a'] == null) return;
        p = p.next[c-'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null; // remove the dup
        }
        
        board[i][j] = '#';
        if (i > 0) dfs(board, p, i-1, j, res);
        if (j > 0) dfs(board, p, i, j-1, res);
        if (i < board.length-1) dfs(board, p, i+1, j, res);
        if (j < board[0].length-1) dfs(board, p, i, j+1, res);
        board[i][j] = c;
    }
}

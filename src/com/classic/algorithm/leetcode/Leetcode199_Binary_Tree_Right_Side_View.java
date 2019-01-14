package com.classic.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            int[] level = new int[1];
            level[0] = 0;
            helper(root, level, 0, res);
        }
        
        return res;
    }
    
    public void helper(TreeNode node, int[] level, int curLevel, List<Integer> res) {
        if (node == null) return;
        curLevel++;
        if (level[0] < curLevel) {
            level[0] = curLevel;
            
            res.add(node.val);
        }
        
        helper(node.right, level, curLevel, res);
        helper(node.left, level, curLevel, res);
    }
}
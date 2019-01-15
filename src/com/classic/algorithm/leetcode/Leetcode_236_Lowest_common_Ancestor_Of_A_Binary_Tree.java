package com.classic.algorithm.leetcode;

public class Leetcode_236_Lowest_common_Ancestor_Of_A_Binary_Tree {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }
    
    public boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        int left = helper(node.left, p, q) ? 1 : 0;
        int right = helper(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        if (mid + left + right >= 2) res = node;
        return mid+left+right > 0;
    }
    // Time: O(N), Space: O(N)
}
package com.classic.algorithm.leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Leetcode968BinaryTreeCameras {
    private int NOT_MONITER = 0;
    private int MONITER_NOCAM = 1;
    private int MONITER_WITHCAM = 2;
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        int[] cameras = new int[1];
        int ro = helper(root, cameras);
        return cameras[0] + (ro == NOT_MONITER ? 1 : 0);
    }
    private int helper(TreeNode node, int[] cameras) {
        if (node == null) return MONITER_NOCAM;
        int left = helper(node.left, cameras);
        int right = helper(node.right, cameras);
        if (left == MONITER_NOCAM && right == MONITER_NOCAM) return NOT_MONITER;
        else if (left == NOT_MONITER || right == NOT_MONITER) {
            cameras[0]++;
            return MONITER_WITHCAM;
        } else return MONITER_NOCAM;
    }
}
// Time O(N), Space O(NlogN)